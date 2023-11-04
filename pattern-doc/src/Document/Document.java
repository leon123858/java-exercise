package Document;

public abstract class Document {
    public String type;
    protected boolean isShown;

    Document() {
        this.isShown = false;
    }

    public abstract void write();

    public void present() {
        if (!this.isShown) {
            write();
            this.isShown = true;
        }
    }
}
