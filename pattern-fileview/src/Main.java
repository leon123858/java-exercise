import Service.ViewService;
import Command.Command;
import Command.CommandFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            // read file like format `java Main inputFile`
            if (args.length != 1) {
                // System.out.println("Wrong Input");
                args = new String[1];
                args[0] = "./src/sampleInput";
            }
            String inputFilePath = args[0];
            ArrayList<Command> commands = new ArrayList<>();
            try {
                File myObj = new File(args[0]);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    commands.add(CommandFactory.createCommand(data));
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                return;
            }
            // create views
             ViewService viewService = new ViewService();
            // execute commands
            for (Command command : commands) {
                command.execute(viewService);
            }

    }
}