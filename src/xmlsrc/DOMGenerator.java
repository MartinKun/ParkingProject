
package xmlsrc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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


public abstract class DOMGenerator {
    
    protected Document document;
    
    protected DOMGenerator() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
    }
    
    protected abstract void generateDocument();
    
    protected void generateXML(File file) throws TransformerConfigurationException, IOException, TransformerException {
        
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            
            Source source = new DOMSource(document);
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            Result result = new StreamResult(pw);
            
            transformer.transform(source, result);
            pw.close();
            fw.close();
    }
    
}
