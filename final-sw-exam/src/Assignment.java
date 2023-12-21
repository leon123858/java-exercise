public class Assignment {
    private final String id;
    private final Rubric rankingCriterion;

    public Assignment(String id, Rubric rankingCriterion) {
        this.id = id;
        this.rankingCriterion = rankingCriterion;
    }

    public String getId() { return id; }
    public Rubric getRankingCriterion() { return rankingCriterion; }
}
