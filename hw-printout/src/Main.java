import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
//            System.out.println("Wrong Input");
//            return;
            args = new String[1];
            args[0] = "./src/sampleInput";
        }
        String inputFilePath = args[0];
        HashMap<String, CustomList> dataStructures = new HashMap<>();
        try {
            File myObj = new File(inputFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] tokens = data.split(" ");
                switch (tokens[0]) {
                    case "Create":
                        createDataStructure(tokens[1], dataStructures, tokens[2]);
                        break;
                    case "Add":
                        addContent(tokens[1], tokens[2], dataStructures);
                        break;
                    case "Length":
                        getLength(tokens[1], dataStructures);
                        break;
                    case "Size":
                        getSize(tokens[1], dataStructures);
                        break;
                    case "Get":
                        getIndexValue(tokens[1], Integer.parseInt(tokens[2]), dataStructures);
                        break;
                    case "GetNode":
                        getNode(tokens[1], Integer.parseInt(tokens[2]), dataStructures);
                        break;
                    case "PrintOutList":
                        printList(tokens[1], dataStructures);
                        break;
                    default:
                        System.out.println("Invalid command");
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return;
        }
    }

    private static void createDataStructure(String name, HashMap<String, CustomList> dataStructures, String type) {
        switch (type) {
            case "List":
                dataStructures.put(name, new CustomListImp(name));
                break;
            case "List1":
                throw new UnsupportedOperationException("Not supported yet.");
            default:
                throw new InvalidParameterException("Not exist type.");
        }
    }

    private static void addContent(String name, String content, HashMap<String, CustomList> dataStructures) {
       var dataList = dataStructures.get(name);
        if (dataList != null) {
            dataList.add(content);
        } else {
            System.out.println(name + " does not exist.");
        }
    }

    private static void getLength(String name, Map<String, List<String>> dataStructures) {
        List<String> dataList = dataStructures.get(name);
        if (dataList != null) {
            System.out.println(name + " length: " + dataList.size());
        } else {
            System.out.println(name + " does not exist.");
        }
    }

    private static void getSize(String name, Map<String, List<String>> dataStructures) {
        List<String> dataList = dataStructures.get(name);
        if (dataList != null) {
            System.out.println(name + " size: " + dataList.size());
        } else {
            System.out.println(name + " does not exist.");
        }
    }

    private static void getIndexValue(String name, int index, Map<String, List<String>> dataStructures) {
        List<String> dataList = dataStructures.get(name);
        if (dataList != null && index >= 0 && index < dataList.size()) {
            System.out.println(name + "[" + index + "]: " + dataList.get(index));
        } else {
            System.out.println("Invalid index or " + name + " does not exist.");
        }
    }

    private static void getNode(String name, int index, Map<String, List<String>> dataStructures) {
        List<String> dataList = dataStructures.get(name);
        if (dataList != null && index >= 0 && index < dataList.size()) {
            System.out.println("Node at index " + index + " in " + name + ": " + dataList.get(index));
        } else {
            System.out.println("Invalid index or " + name + " does not exist.");
        }
    }

    private static void printList(String name, Map<String, List<String>> dataStructures) {
        List<String> dataList = dataStructures.get(name);
        if (dataList != null) {
            System.out.println(name + " contents: " + dataList);
        } else {
            System.out.println(name + " does not exist.");
        }
    }
}