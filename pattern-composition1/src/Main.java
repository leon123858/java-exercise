import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
            IComponent root = new Component("Root");
            for (int i = 0; i < nodeList.getLength(); i++) {
                var node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    root.add(dfs(node));
                }
            }
            // Print
            for (IComponent child : root.getChildren()) {
                child.dfs();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static IComponent dfs(Node rootNode) {
        var type = rootNode.getNodeName();
        IComponent cur;
        if (type.equals("Group")) {
            cur = new Component(type);
            var nodeList = rootNode.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                var node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    cur.add(dfs(node));
                }
            }
        } else {
            cur = new Leaf(type);
        }
        return cur;
    }
}
