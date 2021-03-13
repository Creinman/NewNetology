import java.util.*;

public class Main {
    public void main(String[] args) {
        List<Employee> list = parseXML("data.xml");

        JSONArray arrayJSON = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
             =list.get(i);
            arrayJSON.put(list.get(i));
        }
        try (FileWriter file = new
                FileWriter("new_data.json")) {
            file.write(arrayJSON.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName){
        DocumentBuilderFactory factory = DocumentBuilderFactory. newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse( new File(fileName));
        Node root = doc.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element employee = (Element) node;
                Node node = nodeList.item(i);
                list.add(node.getNodeName());
            }
        }
    }
}
