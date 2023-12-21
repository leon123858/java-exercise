public class Rubric {
    private Level level;
    private Criterion criterion;
    private String description;

    public Rubric(Level level, Criterion criterion, String description) {
        this.level = level;
        this.criterion = criterion;
        this.description = description;
    }

    public Level getLevel() { return level; }
    public Criterion getCriterion() { return criterion; }
    public String getDescription() { return description; }
}
