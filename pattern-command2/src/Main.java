import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
//            System.out.println("Wrong Input");
//            return;
            args = new String[1];
            args[0] = "./src/Sample0.in";
        }
        String inputFilePath = args[0];
        ArrayList<Command> commands = new ArrayList<>();
        try {
            File myObj = new File(inputFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitData = data.split(" ");
                switch (splitData[0]) {
                    case "print":
                        commands.get(Integer.parseInt(splitData[1])).print();
                        break;
                    case "generateCode":
                        commands.get(Integer.parseInt(splitData[1])).generate();
                        break;
                    case "checkType":
                        commands.get(Integer.parseInt(splitData[1])).type();
                        break;
                    default:
                        Command command = parseCommand(data);
                        commands.add(command);
                        break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    private static Command parseCommand(String input) {
        // 使用正则表达式匹配两种可能的格式
        String constantPattern = "AssignmentNode\\((\\w+),\\s(\\d+)\\)";
        String variableRefPattern = "AssignmentNode\\((\\w+),\\sVariableRefNode\\((\\w+)\\)\\)";

        Pattern constantRegex = Pattern.compile(constantPattern);
        Pattern variableRefRegex = Pattern.compile(variableRefPattern);

        // 尝试匹配常量格式
        Matcher constantMatcher = constantRegex.matcher(input);
        if (constantMatcher.matches()) {
            String variableName = constantMatcher.group(1);
            int constantValue = Integer.parseInt(constantMatcher.group(2));
            return new AssignCommand(variableName, constantValue, input);
        }

        // 尝试匹配变量引用格式
        Matcher variableRefMatcher = variableRefRegex.matcher(input);
        if (variableRefMatcher.matches()) {
            String variableName = variableRefMatcher.group(1);
            String referencedVariable = variableRefMatcher.group(2);
            return new RefCommand(variableName,referencedVariable, input);
        }

        // 如果没有匹配成功，可以抛出异常或返回空，具体取决于你的需求
        throw new IllegalArgumentException("Invalid input format");
    }
}