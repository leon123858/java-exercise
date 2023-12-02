import java.io.FileNotFoundException;

public class CsvFileReader extends FileReader{
    CsvFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public void read() {
        if(!this.isExist()){
            System.out.println("Failed to read " + this.filePath);
            return;
        }
        if(!this.isCsv()){
            System.out.println("Failed to read " + this.filePath);
            return;
        }
        try {
            this.print();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to read " + this.filePath);
        }
    }
}
