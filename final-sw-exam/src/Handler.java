public interface Handler {
    void setNext(Handler handler);
    boolean handleRequest(AssignmentFiles files) throws Exception;
}
