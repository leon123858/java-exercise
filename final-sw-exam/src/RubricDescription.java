public class RubricDescription {
    private final Level level;
    private final Criterion criterion;
    private final String description;

    public RubricDescription(Level level, Criterion criterion, String description) {
        this.level = level;
        this.criterion = criterion;
        this.description = description;
    }

    public Level getLevel() { return level; }
    public Criterion getCriterion() { return criterion; }
    public String getDescription() { return description; }
}
