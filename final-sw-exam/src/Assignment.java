public class Assignment {
    private final String id;
    private final RankingCriterion rankingCriterion;

    public Assignment(String id, RankingCriterion rankingCriterion) {
        this.id = id;
        this.rankingCriterion = rankingCriterion;
    }

    public String getId() { return id; }
    public RankingCriterion getRankingCriterion() { return rankingCriterion; }
}
