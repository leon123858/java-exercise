public class Rank {
    private Student reviewer;
    private Level level;
    private Criterion criterion;

    public Rank(Student reviewer, Level level, Criterion criterion) {
        this.reviewer = reviewer;
        this.level = level;
        this.criterion = criterion;
    }

    public Student getReviewer() {
        return reviewer;
    }

    public Level getLevel() {
        return level;
    }

    public Criterion getCriterion() {
        return criterion;
    }
}
