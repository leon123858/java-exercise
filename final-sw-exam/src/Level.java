public class Level {
    private final String name;
    private final int score;

    public Level(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }
}
