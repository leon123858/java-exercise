package Document;

public class TextDocument extends Document {
    public TextDocument() {
        super();
        this.type = "TextDocument";
    }

    @Override
    public void write() {
        System.out.println("TextDocument");
    }
}
