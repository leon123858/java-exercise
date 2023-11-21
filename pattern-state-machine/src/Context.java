public class Context {
    private State state;

    public Context() {
        state = new EmptyState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doAction(String action) {
        this.state.doAction(this, action);
    }
}
