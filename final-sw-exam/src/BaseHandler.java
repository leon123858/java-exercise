public class BaseHandler implements Handler {
    private Handler nextHandler;

    public BaseHandler() {
        this.nextHandler = null;
    }

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(AssignmentFiles files) throws Exception {
        if (this.nextHandler != null) {
            this.nextHandler.handleRequest(files);
        }
    }
}
