public class Level {
    private final String name;
    private final double score;

    public Level(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public double getScore() { return score; }
}
