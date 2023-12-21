import java.util.List;

public interface RankingStrategy {
    double getRanking(List<Rank> ranks);
}
