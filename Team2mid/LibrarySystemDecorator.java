public abstract class LibrarySystemDecorator implements ILibrarySystem {
    protected final ILibrarySystem inner;

    public LibrarySystemDecorator(ILibrarySystem librarySystem) {
        inner = librarySystem;
    }
}
