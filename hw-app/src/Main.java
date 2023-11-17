import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong Input");
//            return;
            args = new String[1];
            args[0] = "./src/sampleInput";
        }
        String inputFilePath = args[0];
        ArrayList<Command> commands = new ArrayList<>();
        try {
            File myObj = new File(inputFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                commands.add(new Command(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return;
        }
        VM vm = new VM();
        for (Command command : commands) {
            command.execute(vm);
        }
    }
}