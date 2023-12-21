public class DuplicateReviewerHandler extends BaseHandler {
    @Override
    public boolean handleRequest(AssignmentFiles files) throws Exception {
        var reviewers = files.getScoreList().stream().map(s -> s.reviewerId).toList();

        if (reviewers.size() != reviewers.stream().distinct().count()) {
            throw new Exception("Duplicate reviewers");
        }

        return super.handleRequest(files);
    }
}
