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
    public boolean handleRequest(AssignmentFiles files) throws Exception {
        var scores = files.getScoreList();

        if (scores.size() < reviewerMin || scores.size() > reviewerMax) {
            System.out.printf("Assignment should be reviewed by %s-%s students.\n", reviewerMin, reviewerMax);
            return false;
        }

        return super.handleRequest(files);
    }
}
