import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // read file like format `java Main inputFile`
        if (args.length != 1) {
            // System.out.println("Wrong Input");
            args = new String[1];
            args[0] = "./src/sample0.in";
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
        Enum<FILE_FORMAT> fileFormat = null;
        while (myReader.hasNextLine()) {
            String command = myReader.nextLine();
            String[] commandArray = command.split(" ");
            if (commandArray[0].equals("read")) {
                if (fileFormat == null) {
                    System.out.println("Wrong Input");
                } else {
                    switch (fileFormat) {
                        case FILE_FORMAT.TXT:
                        {
                            FileReader txtFileReader = new TxtFileReader(commandArray[1]);
                            txtFileReader.read();
                            break;
                        }
                        case FILE_FORMAT.CSV:{
                            FileReader csvFileReader = new CsvFileReader(commandArray[1]);
                            csvFileReader.read();
                            break;
                        }
                        default:
                            System.out.println("Wrong Input");
                            break;
                    }
                }
            }else{
                switch (commandArray[0]) {
                    case "text":
                        fileFormat = FILE_FORMAT.TXT;
                        break;
                    case "spreadsheet":
                        fileFormat = FILE_FORMAT.CSV;
                        break;
                    default:
                        System.out.println("Wrong Input");
                        break;
                }
            }
        }
        return myReader;
    }
}