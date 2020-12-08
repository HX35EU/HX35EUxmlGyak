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
			//File objektum létrehozás
		File file = new File("XMLHx35eu.xml");

		//File beolvasás
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

		//XML normalizálása
		Element root = doc.getDocumentElement();
		root.normalize();

		//Az összes node lekérdezése, mely a Termék nevet viseli
		NodeList nodes = doc.getElementsByTagName("Termék");

		//Végigiterálunk a nodeokon
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);

			//Ha a 3. nodehoz értünk
			if (Integer.parseInt(node.getAttributes().getNamedItem("TERMEK_ID").getNodeValue()) == 3) {
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					//Átállítjuk a készletet 12000-re.
					eElement.getElementsByTagName("Készlet").item(0).setTextContent("12000");
				}
			}
		}

		//File kiíratás az eredeti felülírásával
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(file);
		transformer.transform(source, result);
	}
}
