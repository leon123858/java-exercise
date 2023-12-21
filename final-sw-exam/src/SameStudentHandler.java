import java.util.Objects;

public class SameStudentHandler extends BaseHandler {
    @Override
    public void handleRequest(AssignmentFiles files) throws Exception {
        var student = files.studentID;
        var reviewers = files.getScoreList().stream().map(s -> s.reviewerId).toList();

        if (reviewers.contains(student)) {
            System.out.println("Cannot review one’s own assignment.");
            throw new Exception("Cannot review one’s own assignment.");
        }

        super.handleRequest(files);
    }
}
