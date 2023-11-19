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
        Context context = new Context();
        while (myReader.hasNextLine()) {
            String command = myReader.nextLine();
            context.doAction(command);
        }
        return myReader;
    }
}