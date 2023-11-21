public class EndState implements State{
    public void doAction(Context context, String action) {
        if(action.equals("Drain")) {
            System.out.println("Drain the boiled chocolate");
            context.setState(new EmptyState());
        }
    }
}
