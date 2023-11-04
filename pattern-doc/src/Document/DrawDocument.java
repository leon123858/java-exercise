package Document;

public class DrawDocument extends Document {

    public DrawDocument() {
        super();
        this.type = "DrawDocument";
    }

    @Override
    public void write() {
        System.out.println("DrawingDocument");
    }
}
