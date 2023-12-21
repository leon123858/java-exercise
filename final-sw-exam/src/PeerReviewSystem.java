import java.util.Dictionary;
import java.util.List;
import java.util.Objects;

public class PeerReviewSystem {
    private List<Level> levels;
    private List<Student> students;
    private Dictionary<String, Assignment> assignments;
    private List<DoAssignment> doAssignments;

    public void AddStudent(Student student) {
        students.add(student);
    }

    public void AddLevel(Level level) {
        levels.add(level);
    }

    public void DesignCriterion(String assignmentId, List<CriteriaFiles> criteriaFiles) {

        var rankingCriterion = new Rubric();
        var newAssignment = new Assignment(assignmentId, rankingCriterion);

        for (var student : students) {
            var doAssignment = new DoAssignment(student, newAssignment);
            doAssignments.add(doAssignment);
        }
    }

    public void Assignment(String assignmentId, String studentId, List<ScoreFiles> scoreFiles) {
        var assignment = assignments.get(assignmentId);
        var student = students.stream().filter(s -> Objects.equals(s.getId(), studentId)).findFirst().get();

        //TODO: add score to doAssignment

    }

    public void PrintRubric(String assignmentId) {
        var assignment = assignments.get(assignmentId);

        for (var rubric : assignment.getRankingCriterion().getDescriptions()) {
            System.out.println("(" + rubric.getLevel().getName() + "," + rubric.getCriterion().getName() + ") " + rubric.getDescription());
        }
    }

    public void AverageCriterion(String assignmentId) {
        var assignment = assignments.get(assignmentId);

        var totalScore = 0.0;

        var ranks = doAssignments.stream().filter(a -> a.getAssignment().equals(assignment)).map(DoAssignment::getRanks).toList();

        for (var criterion : assignment.getRankingCriterion().getCriteria()) {
        }
    }

    public void calculateScore(String assignmentId, String studentId, String rankingStrategy) {
    }

    public void findStrength(String assignmentId, String studentId, String rankingStrategy) {
    }

    public void findWeakness(String assignmentId, String studentId, String rankingStrategy) {
    }
}
