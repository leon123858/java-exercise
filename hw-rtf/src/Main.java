import java.io.File;
import java.io.FileNotFoundException;
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
        try {
            File myObj = new File(inputFilePath);
            Scanner myReader = getMyReader(myObj);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    private static Scanner getMyReader(File myObj) throws FileNotFoundException {
        Scanner myReader = new Scanner(myObj);
        int stage = 0;
        String tmpTextFormat = "";
        while (myReader.hasNextLine()) {
            String command = myReader.nextLine();
            switch (stage) {
                case 0:
                    // First stage: Input format
                    stage++;
                    tmpTextFormat = command;
                    break;
                case 1:
                    // Second stage: Input RTF tokens
                    stage--;
                    switch (tmpTextFormat) {
                        case "TeX":
                            Interpreter texInterpreter = new TexInterpreter();
                            System.out.println(texInterpreter.interpret(command));
                            break;
                        case "TextWidget":
                            Interpreter widgetInterpreter = new WidgetInterpreter();
                            System.out.println(widgetInterpreter.interpret(command));
                            break;
                        default:
                            System.out.println("Wrong Input");
                            break;
                    }
                    break;
            }
        }
        return myReader;
    }
}