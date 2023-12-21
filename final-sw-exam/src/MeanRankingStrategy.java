import java.util.List;

public class MeanRankingStrategy implements RankingStrategy {
    @Override
    public double calculate(List<Rank> ranks) {
        var sum = 0.0;
        for (Rank rank : ranks) {
            sum += rank.getLevel().getScore();
        }
        return sum / ranks.size();
    }
}
