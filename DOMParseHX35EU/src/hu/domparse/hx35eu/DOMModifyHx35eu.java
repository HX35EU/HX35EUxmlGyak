package hu.domparse.hx35eu;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMModifyHx35eu {

	public static void main(String[] args)
			throws ParserConfigurationException, IOException, SAXException, TransformerException {
		File file = new File("XMLHx35eu.xml");

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

		Element root = doc.getDocumentElement();
		root.normalize();

		NodeList nodes = doc.getElementsByTagName("Termék");

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);

			if (Integer.parseInt(node.getAttributes().getNamedItem("TERMEK_ID").getNodeValue()) == 3) {
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					eElement.getElementsByTagName("Készlet").item(0).setTextContent("12000");
				}
			}
		}

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(file);
		transformer.transform(source, result);
	}
} 
