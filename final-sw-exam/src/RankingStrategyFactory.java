public class RankingStrategyFactory {
    public static RankingStrategy create(String rankingStrategy) {
        if (rankingStrategy.equals("Average")) {
            return new MeanRankingStrategy();
        } else {
            throw new IllegalArgumentException("Invalid ranking strategy");
        }
    }
}
