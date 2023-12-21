import java.util.LinkedList;
import java.util.List;

public class DoAssignment {
    private final Student student;
    private final Assignment assignment;
    private final List<Rank> ranks;

    public DoAssignment(Student student, Assignment assignment) {
        this.student = student;
        this.assignment = assignment;
        this.ranks = new LinkedList<>();
    }

    public Student getStudent() {
        return student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public List<Rank> getRanksByCriterion(Criterion criterion) {
        return ranks.stream().filter(r -> r.getCriterion().equals(criterion)).toList();
    }

    public void addRank(Rank rank) {
        ranks.add(rank);
    }
}
