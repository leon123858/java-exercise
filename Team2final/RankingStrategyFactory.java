public class RankingStrategyFactory {
    public static RankingStrategy create(String rankingStrategy) {
        if (rankingStrategy.equals("MeanRankingStrategy")) {
            return new MeanRankingStrategy();
        } else if (rankingStrategy.equals("MedianRankingStrategy")) {
                return new MedianRankingStrategy();
        } else {
            throw new IllegalArgumentException("Invalid ranking strategy");
        }
    }
}
