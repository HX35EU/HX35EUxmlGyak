 package domHX35EU;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParserHX35EU {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			Document doc = dbBuilder.parse("szemelyek.xml");
			doc.getDocumentElement().normalize();
			System.out.println("root element :"+doc.getDocumentElement().getNodeName());
			System.out.println("-------------------");
			NodeList nList = doc.getElementsByTagName("szemely");
			for(int temp = 0;temp<nList.getLength();temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\ncurrent element:"+nNode.getNodeName());
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println(eElement.getAttribute("id"));
					Node actualNode = eElement.getFirstChild();
					while (actualNode != null) {
						if(actualNode.getNodeType() == Element.ELEMENT_NODE) {
							Element actualElement = (Element)actualNode;
							System.out.println(actualElement.getNodeName()+":"+actualElement.getTextContent());
						}
						actualNode = actualNode.getNextSibling();
					}
					System.out.println();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
