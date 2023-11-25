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
        }
    }

    private static void createDataStructure(String name, HashMap<String, CustomList> dataStructures, String type) {
        switch (type) {
            case "List":
                dataStructures.put(name, new CustomListImp(name));
                break;
            case "SkipList":
                dataStructures.put(name, new SkipListImp(name));
                break;
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

    private static void getLength(String name, HashMap<String, CustomList> dataStructures) {
        CustomList dataList = dataStructures.get(name);
        if (dataList != null) {
            try {
                System.out.println(dataList.length());
            } catch (UnsupportedOperationException e) {
                System.out.println("SkipList can not access length");
            }
        } else {
            System.out.println(name + " does not exist.");
        }
    }

    private static void getSize(String name, HashMap<String, CustomList> dataStructures) {
        CustomList dataList = dataStructures.get(name);
        if (dataList != null) {
            try {
                System.out.println(dataList.size());
            } catch (UnsupportedOperationException e) {
                System.out.println("List do not have method size");
            }
        } else {
            System.out.println(name + " does not exist.");
        }
    }

    private static void getIndexValue(String name, int index, HashMap<String, CustomList> dataStructures) {
        CustomList dataList = dataStructures.get(name);
        try {
            if (dataList != null) {
                System.out.println(dataList.get(index));
            } else {
                throw new IndexOutOfBoundsException("Invalid index or " + name + " does not exist.");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("SkipList do not have method get");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getNode(String name, int index, HashMap<String, CustomList> dataStructures) {
        CustomList dataList = dataStructures.get(name);
        try {
            if (dataList != null) {
                System.out.println(dataList.getNode(index));
            } else {
                throw new IndexOutOfBoundsException("Invalid index or " + name + " does not exist.");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("List do not have method getNode");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printList(String name, HashMap<String, CustomList> dataStructures) {
        CustomList dataList = dataStructures.get(name);
        if (dataList != null) {
            for (CustomIterator iterator = dataList.iterator(); iterator.hasNext();) {
                System.out.println(iterator.next());
            }
        } else {
            System.out.println(name + " does not exist.");
        }
    }
}