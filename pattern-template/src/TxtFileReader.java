import java.io.FileNotFoundException;

public class TxtFileReader extends FileReader {
    TxtFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public void read() {
        if(!this.isExist()){
            System.out.println("Failed to read " + this.filePath);
            return;
        }
        if(!this.isTxt()){
            System.out.println("Failed to read " + this.filePath);
            return;
        }
        try {
            this.print();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to read" + this.filePath);
        }
    }
}
