public class LimitNumberHandler extends BaseHandler {
private final int reviewerMin;
    private final int reviewerMax;

    public LimitNumberHandler(int reviewerMin, int reviewerMax) {
        if (reviewerMin > reviewerMax) {
            throw new IllegalArgumentException("reviewerMin should be less than reviewerMax");
        }

        this.reviewerMin = reviewerMin;
        this.reviewerMax = reviewerMax;
    }

    @Override
    public void handleRequest(AssignmentFiles files) throws Exception {
        var scores = files.getScoreList();

        if (scores.size() < reviewerMin) {
            throw new Exception("Not enough students");
        }

        if (scores.size() > reviewerMax) {
            throw new Exception("Too many students");
        }

        super.handleRequest(files);
    }
}
