import java.util.*;

public class PeerReviewSystem {
    private List<Level> levels;
    private List<Student> students;
    private Map<String, Assignment> assignments;
    private List<DoAssignment> doAssignments;

    PeerReviewSystem() {
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

    public void DesignCriterion(String assignmentId, CriteriaFiles criteriaFiles) {
        var descriptionList = new LinkedList<RubricDescription>();

        var criterionList = criteriaFiles.getCriteriaList();

        for (var criterionString : criterionList) {
            var criterion = new Criterion(criterionString);
            var levelMap = criteriaFiles.get(criterionString);

            for (var level : levels) {
                var description = levelMap.get(level.getName());
                var rubricDescription = new RubricDescription(level, criterion, description);
                descriptionList.add(rubricDescription);
            }
        }

        var rubric = new Rubric(descriptionList);
        var newAssignment = new Assignment(assignmentId, rubric);

        for (var student : students) {
            var doAssignment = new DoAssignment(student, newAssignment);
            doAssignments.add(doAssignment);
        }
    }

    public void Assignment(String assignmentId, String studentId, AssignmentFiles assignmentFiles) {
        var assignment = assignments.get(assignmentId);
        var student = students.stream().filter(s -> Objects.equals(s.getId(), studentId)).findFirst().get();

        var scoreFiles = assignmentFiles.getScoreList();
        for (var scoreFile : scoreFiles) {
            var reviewer = students.stream().filter(s -> Objects.equals(s.getId(), scoreFile.reviewerId)).findFirst().get();
            var doAssignment = doAssignments.stream().filter(a -> a.getAssignment().equals(assignment) && a.getStudent().equals(student)).findFirst().get();

            var scoreIndex = 0;
            for (var criterion : assignment.getRubric().getCriteria()) {
                var levelString = scoreFile.scores.get(scoreIndex);
                var level = levels.stream().filter(l -> Objects.equals(l.getName(), levelString)).findFirst().get();
                var rank = new Rank(reviewer, level, criterion);
                doAssignment.addRank(rank);

                scoreIndex++;
            }
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

    public void calculateScore(String assignmentId, String studentId, String rankingStrategy) {
        var strategy = RankingStrategyFactory.create(rankingStrategy);
    }

    public void findStrength(String assignmentId, String studentId, String rankingStrategy) {
    }

    public void findWeakness(String assignmentId, String studentId, String rankingStrategy) {
    }
}
