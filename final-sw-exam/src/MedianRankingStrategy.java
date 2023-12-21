import java.util.ArrayList;
import java.util.List;

public class MedianRankingStrategy implements RankingStrategy {
    @Override
    public double calculate(List<Rank> ranks) {
        var scores = new ArrayList<>(ranks.stream().map(r -> r.getLevel().getScore()).toList());

        scores.sort(Double::compareTo);
        int length = scores.size();

        if (length % 2 == 0) {
            int middle1 = length / 2 - 1;
            int middle2 = length / 2;
            return (scores.get(middle1) + scores.get(middle2)) / 2.0;
        } else {
            int middle = length / 2;
            return scores.get(middle);
        }
    }
}
