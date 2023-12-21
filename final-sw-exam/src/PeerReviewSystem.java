import java.util.*;

public class PeerReviewSystem {
    private final int reviewerMin;
    private final int reviewerMax;
    private final List<Level> levels;
    private final List<Student> students;
    private final Map<String, Assignment> assignments;
    private final List<DoAssignment> doAssignments;

    public PeerReviewSystem()
    {
        this(3, 5);
    }

    public PeerReviewSystem(int reviewerMin, int reviewerMax) {
        if (reviewerMin > reviewerMax) {
            throw new IllegalArgumentException("reviewerMin should be less than reviewerMax");
        }

        this.reviewerMin = reviewerMin;
        this.reviewerMax = reviewerMax;
        levels = new LinkedList<>();
        students = new LinkedList<>();
        assignments = new HashMap<>();
        doAssignments = new LinkedList<>();
    }

    public void AddStudent(Student student) {
        students.add(student);
    }

    public void AddLevel(Level level) {
        levels.add(level);
    }

    public void DesignCriterion(String assignmentId, CriteriaFiles criteriaFiles) throws Exception {
        if (assignments.containsKey(assignmentId)) {
            throw new Exception("Assignment already exists");
        }

        var descriptionList = new LinkedList<RubricDescription>();

        var criterionList = criteriaFiles.getCriteriaList();
        var criteria = new LinkedList<Criterion>();

        for (var criterionString : criterionList) {
            var criterion = new Criterion(criterionString);
            criteria.add(criterion);
            var levelMap = criteriaFiles.get(criterionString);

            for (var level : levels) {
                var description = levelMap.get(level.getName());
                var rubricDescription = new RubricDescription(level, criterion, description);
                descriptionList.add(rubricDescription);
            }
        }

        var rubric = new Rubric(descriptionList, criteria);
        var newAssignment = new Assignment(assignmentId, rubric);
        assignments.put(assignmentId, newAssignment);

        for (var student : students) {
            var doAssignment = new DoAssignment(student, newAssignment);
            doAssignments.add(doAssignment);
        }
    }

    public void Assignment(String assignmentId, String studentId, AssignmentFiles assignmentFiles) throws Exception {
        if (assignmentFiles.getScoreList().size() < reviewerMin || assignmentFiles.getScoreList().size() > reviewerMax) {
            System.out.printf("Assignment should be reviewed by %s-%s students.\n", reviewerMin, reviewerMax);
            return;
        }

        var assignment = assignments.get(assignmentId);
        var student = students.stream().filter(s -> Objects.equals(s.getId(), studentId)).findFirst().get();
        var doAssignment = doAssignments.stream().filter(a -> a.getAssignment().equals(assignment) && a.getStudent().equals(student)).findFirst().get();

        if (!doAssignment.getRanks().isEmpty()) {
            throw new Exception("Assignment already reviewed");
        }

        var scoreFiles = assignmentFiles.getScoreList();
        for (var scoreFile : scoreFiles) {
            var reviewer = students.stream().filter(s -> Objects.equals(s.getId(), scoreFile.reviewerId)).findFirst().get();

            if (reviewer.equals(student)) {
                System.out.println("Cannot review one’s own assignment.");
                continue;
            }

            var criterionList = assignment.getRubric().getCriteria();

            var scoreIndex = 0;
            for (var criterion : criterionList) {
                var levelString = scoreFile.scores.get(scoreIndex);
                var level = levels.stream().filter(l -> Objects.equals(l.getName(), levelString)).findFirst().get();
                var rank = new Rank(reviewer, level, criterion);
                doAssignment.addRank(rank);

                scoreIndex++;
            }

            System.out.printf("%s-%s was reviewed by %s. Level: %s\n", assignmentId, studentId, scoreFile.reviewerId, String.join(" ", scoreFile.scores.subList(0, criterionList.size())));
        }
    }

    public void PrintRubric(String assignmentId) {
        var assignment = assignments.get(assignmentId);
        assignment.getRubric().PrintRubric();
    }

    public void AverageCriterion(String assignmentId) {
        var assignment = assignments.get(assignmentId);

        var doAssignmentList = doAssignments.stream().filter(a -> a.getAssignment().equals(assignment)).toList();

        for (var criterion : assignment.getRubric().getCriteria()) {
            var criterionRanks = doAssignmentList.stream().flatMap(a -> a.getRanksByCriterion(criterion).stream()).toList();

            var average = criterionRanks.stream().mapToDouble(a -> a.getLevel().getScore()).average().orElse(0.0);

            System.out.printf("Assignment: %s, Criterion: %s, AvgScore: %.1f\n", assignmentId, criterion.getName(), average);
        }
    }

    public void calculateScore(String assignmentId, String studentId, String rankingStrategy) throws Exception {
        var strategy = RankingStrategyFactory.create(rankingStrategy);

        var assignment = assignments.get(assignmentId);
        var doAssignment = doAssignments.stream().filter(a -> a.getAssignment().equals(assignment) && a.getStudent().getId().equals(studentId)).findFirst().get();
        var ranks = doAssignment.getRanks();
        var criterions = assignment.getRubric().getCriteria();

        if (ranks.isEmpty()) {
            throw new Exception("No ranks found");
        }

        var totalScore = 0.0;
        for (var criterion : criterions) {
            var criterionRanks = ranks.stream().filter(r -> r.getCriterion().equals(criterion)).toList();
            var score = strategy.calculate(criterionRanks);

            totalScore += score;
        }

        System.out.printf("Assignment: %s, Student: %s, Score: %.1f\n", assignmentId, studentId, totalScore / criterions.size());
    }

    public void findStrength(String assignmentId, String studentId, String rankingStrategy) throws Exception {
        var strategy = RankingStrategyFactory.create(rankingStrategy);

        var assignment = assignments.get(assignmentId);
        var doAssignment = doAssignments.stream().filter(a -> a.getAssignment().equals(assignment) && a.getStudent().getId().equals(studentId)).findFirst().get();
        var ranks = doAssignment.getRanks();
        var criterions = assignment.getRubric().getCriteria();

        if (ranks.isEmpty()) {
            throw new Exception("No ranks found");
        }

        var criterionScoreMap = new HashMap<Criterion, Double>();

        for (var criterion : criterions) {
            var criterionRanks = ranks.stream().filter(r -> r.getCriterion().equals(criterion)).toList();
            var score = strategy.calculate(criterionRanks);

            criterionScoreMap.put(criterion, score);
        }

        var maxScore = criterionScoreMap.values().stream().max(Double::compareTo).get();
        var criterionString = new StringBuilder();
        for (var criterion : criterions) {
            if (criterionScoreMap.get(criterion).equals(maxScore)) {
                criterionString.append(" ").append(criterion.getName());
            }
        }

        System.out.printf("Assignment: %s, Student: %s, Strength:%s\n", assignmentId, studentId, criterionString);
    }

    public void findWeakness(String assignmentId, String studentId, String rankingStrategy) throws Exception {
        var strategy = RankingStrategyFactory.create(rankingStrategy);

        var assignment = assignments.get(assignmentId);
        var doAssignment = doAssignments.stream().filter(a -> a.getAssignment().equals(assignment) && a.getStudent().getId().equals(studentId)).findFirst().get();
        var ranks = doAssignment.getRanks();

        if (ranks.isEmpty()) {
            throw new Exception("No ranks found");
        }

        var criterions = assignment.getRubric().getCriteria();

        var criterionScoreMap = new HashMap<Criterion, Double>();

        for (var criterion : criterions) {
            var criterionRanks = ranks.stream().filter(r -> r.getCriterion().equals(criterion)).toList();
            var score = strategy.calculate(criterionRanks);

            criterionScoreMap.put(criterion, score);
        }

        var minScore = criterionScoreMap.values().stream().min(Double::compareTo).get();

        var criterionString = new StringBuilder();
        for (var criterion : criterions) {
            if (criterionScoreMap.get(criterion).equals(minScore)) {
                criterionString.append(" ").append(criterion.getName());
            }
        }

        System.out.printf("Assignment: %s, Student: %s, Weakness:%s\n", assignmentId, studentId, criterionString);
    }
}
