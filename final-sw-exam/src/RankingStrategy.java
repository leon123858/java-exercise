import java.util.List;

public interface RankingStrategy {
    double calculate(List<Rank> ranks);
}
