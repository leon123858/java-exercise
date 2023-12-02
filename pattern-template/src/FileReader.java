import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public abstract class FileReader {
    protected final String filePath;

    private static boolean isValidCSV(String document) {
        // 按行拆分文档
        String[] lines = document.split("\n");

        if (lines.length == 0) {
            // 为空则无效
            return false;
        }

        // 获取第一行的字段数量
        int expectedFieldCount = countFields(lines[0]);

        // 检查每一行的字段数量是否一致
        for (String line : lines) {
            if (countFields(line) != expectedFieldCount) {
                return false;
            }
        }

        return true;
    }

    private static int countFields(String line) {
        // 按逗号分隔字段
        String[] fields = line.split(",");

        // 过滤掉可能的空格
        String[] trimmedFields = Arrays.stream(fields)
                .map(String::trim)
                .toArray(String[]::new);

        return trimmedFields.length;
    }


    FileReader(String filePath) {
        this.filePath = filePath;
    }
    protected Boolean isExist() {
        try {
            File file = new File(this.filePath);
            new Scanner(file);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
    protected Boolean isTxt() {
        try{
            Path path = FileSystems.getDefault().getPath(this.filePath);
            String mimeType = Files.probeContentType(path);
            return mimeType.equals("text/plain");
        }catch (IOException e){
            return false;
        }
    }

    protected Boolean isCsv() {
        try{
            Path path = FileSystems.getDefault().getPath(this.filePath);
//            String mimeType = Files.probeContentType(path);
//            if (!mimeType.equals("text/plain")){
//                return false;
//            }
            // 使用 Files.readAllBytes() 读取文件的所有字节
            byte[] fileBytes = Files.readAllBytes(path);
            // 将字节数组转换为字符串
            String content = new String(fileBytes);
            return isValidCSV(content);
        }catch (IOException e){
            return false;
        }
    }

    protected void print() throws FileNotFoundException {
        File file = new File(this.filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
    public abstract void read();
}
