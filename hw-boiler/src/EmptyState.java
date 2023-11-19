public class EmptyState implements State{
    public void doAction(Context context, String action) {
        if(action.equals("Fill")) {
            System.out.println("Fill chocolate");
            context.setState(new BoilState());
        }
    }
}
