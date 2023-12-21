public interface Handler {
    void setNext(Handler handler);
    void handleRequest(AssignmentFiles files) throws Exception;
}
