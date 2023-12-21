public class RankingStrategyFactory {
    public static RankingStrategy create(String rankingStrategy) {
        if (rankingStrategy.equals("MeanRankingStrategy")) {
            return new MeanRankingStrategy();
        } else {
            throw new IllegalArgumentException("Invalid ranking strategy");
        }
    }
}
