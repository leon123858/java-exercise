import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            // System.out.println("Wrong Input");
            args = new String[1];
            args[0] = "./src/sampleInput";
        }

        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file
            Document document = builder.parse(args[0]);
            // Get the root element
            Element rootElement = document.getDocumentElement();
            var nodeList = rootElement.getChildNodes();
            var root = new Component("Root");
            for (int i = 0; i < nodeList.getLength(); i++) {
                var node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    root.add(dfs(node));
                }
            }
            // Print
            for (Component child : root.getChildren()) {
                child.dfs();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Component dfs(Node rootNode) {
        var type = rootNode.getNodeName();
        var cur = new Component(type);
        if (type.equals("Group")) {
            var nodeList = rootNode.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                var node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    cur.add(dfs(node));
                }
            }
        }else{
            cur.add(new Component(type));
        }
        return cur;
    }
}
