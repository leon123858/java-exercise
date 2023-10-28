package editor;

public class Element {
    public String componentId;
    public int naturalSize;
    public int shrinkability;
    public int stretchability;
    public String content;

    public static class Builder {
        private String componentId;
        private int naturalSize;
        private int shrinkability;
        private int stretchability;
        private String content;

        public void componentId(String componentId) {
            this.componentId = componentId;
        }

        public void naturalSize(int naturalSize) {
            assert naturalSize >= 0;
            this.naturalSize = naturalSize;
        }

        public void shrinkability(int shrinkability) {
            assert shrinkability >= 0;
            this.shrinkability = shrinkability;
        }

        public void stretchability(int stretchability) {
            assert stretchability >= 0;
            this.stretchability = stretchability;
        }

        public void content(String content) {
            this.content = content;
        }

        public Element build() {
            assert stretchability >= shrinkability && shrinkability >= 0;
            assert naturalSize >= shrinkability && naturalSize <= stretchability;
            return new Element(componentId, naturalSize, shrinkability, stretchability, content);
        }
    }

    public Element(String componentId,int naturalSize,int shrinkability,int stretchability,String content){
        this.componentId = componentId;
        this.naturalSize = naturalSize;
        this.shrinkability = shrinkability;
        this.stretchability = stretchability;
        this.content = content;
    }

    public void updateSize(int size) {
        if (size < shrinkability || size > stretchability) {
            System.out.println("component " + componentId +" failed to change size");
            return;
        }
        this.naturalSize = size;
        System.out.println("component " + componentId + " size changed to " + Integer.toString(size));
    }
}
