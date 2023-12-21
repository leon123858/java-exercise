import java.util.List;

public class PeerReviewSystem {
    private List<Level> levels;
    private List<Student> students;
    private List<Assignment> assignments;
    private List<DoAssignment> doAssignments;

    public void AddStudent(Student student) {
        students.add(student);
    }

    public void AddLevel(Level level) {
        levels.add(level);
    }

    public void DesignCriterion(String assignmentId, List<CriteriaFiles> criteriaFiles) {
    }

    public void Assignment(String assignmentId, String studentId, List<ScoreFiles> scoreFiles) {

    }

    public void PrintRubric(String assignmentId) {
    }

    public void AverageCriterion(String assignmentId) {
    }

    public void calculateScore(String assignmentId, String studentId, String rankingStrategy) {
    }

    public void findStrength(String assignmentId, String studentId, String rankingStrategy) {
    }

    public void findWeakness(String assignmentId, String studentId, String rankingStrategy) {
    }
}
