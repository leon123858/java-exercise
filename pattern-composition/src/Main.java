import editor.Command;
import editor.Element;

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
        // database
        ArrayList<Element> dataArr = new ArrayList<>();
        ArrayList<Command> commands = new ArrayList<>();
        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                commands.add(new Command(data,dataArr));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return;
        }
        // execute commands
        for (Command command : commands) {
            command.execute();
        }
    }
}