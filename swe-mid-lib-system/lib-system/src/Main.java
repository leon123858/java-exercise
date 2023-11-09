public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong Input");
//            return;
            args = new String[1];
            args[0] = "./test/sample.in";
        }
        String inputFilePath = args[0];
        CommandRunner.run(inputFilePath);
    }
}