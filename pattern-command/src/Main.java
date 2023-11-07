import Command.Command;
import Command.DrawCommand;
import Command.PresentCommand;
import Command.TextCommand;
import Service.FileService;

import javax.naming.NotContextException;
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
                switch (data) {
                    case "Text":
                        commands.add(new TextCommand());
                        break;
                    case "Draw":
                        commands.add(new DrawCommand());
                        break;
                    case "Present":
                        commands.add(new PresentCommand());
                        break;
                    default:
                        System.out.println("Wrong Input");
                        throw new NotContextException();
                }
            }
            myReader.close();
        } catch (FileNotFoundException | NotContextException e) {
            throw new RuntimeException(e);
        }
        // create views
        FileService fileService = new FileService();
        // execute commands
        for (Command command : commands) {
            command.execute(fileService);
        }
    }
}