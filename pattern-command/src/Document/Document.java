package Document;

public abstract class Document {
    public String type;

    public abstract void write();

    public void present() {
            write();
    }
}
