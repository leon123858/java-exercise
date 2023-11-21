public class BoilState implements State{
    public void doAction(Context context, String action) {
        if(action.equals("Boil")) {
            System.out.println("Boil chocolate");
            context.setState(new EndState());
        }
    }
}
