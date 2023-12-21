import java.util.List;

public class MedianRankingStrategy implements RankingStrategy {
    @Override
    public double calculate(List<Rank> ranks) {

        var scores = ranks.stream().map(r -> r.getLevel().getScore()).toList();

        //TODO
        return 0;
    }
}
