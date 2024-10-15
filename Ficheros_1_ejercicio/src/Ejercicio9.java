
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Ejercicio9 {

	public final static String RUTA_DATOS = System.getProperty("user.dir") + 
			System.getProperty("file.separator") + 
			"src" +
			System.getProperty("file.separator") +
			"datos" + 
			System.getProperty("file.separator"); 
	private final static String DATOSFILE = "Ejercicio9.xml";
	
	public static void main(String[] args) {

		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder constructor = factory.newDocumentBuilder();
			
			Document doc = constructor.parse(new File(RUTA_DATOS + DATOSFILE));

			TransformerFactory tF = TransformerFactory.newInstance();
			Transformer t= tF.newTransformer();
			
			t.transform(new DOMSource(doc), new StreamResult(System.out));

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

}