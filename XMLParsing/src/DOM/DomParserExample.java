/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOM;
    import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author HP PAVİLİON 15
 */
public class DomParserExample {

    public static void main(String[] args) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
 
      /*Bir XML dosyası okumak için öncelikle bir DocumentBuilder üretiyoruz bunun için DocumentBuilderFactor'e
      ihtiyacımız var çünkü DocumentBuilder' onun üzerinden oluşturmamız gerekiyor*/
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder  build=factory.newDocumentBuilder();
        /*Burada öncelikle parse etmek istediğimiz XML dosyasının bulunduğu yolu FileInputStream içine atıyoruz
        daha sonra daha önceden oluşturduğumuz builder ile çözümleyerek bir Document değişkenine atıyoruz. */
        Document document=build.parse(new FileInputStream("file.xml"));
        /*Burada kısaca getElementsByTagName metodunun kulanımından bahsedersek bir document'in içindeki
        spesifik bir tag'in kapsadığı tüm elemanları döndürmemize yarayan NodeList objesidir.
        Devamında ise dosyanın içindeki elementleri Nodelist objesine atıyoruz.*/
        NodeList tree=document.getElementsByTagName("calisan");
        //Kök elemanımızı alarak yazdırıyoruz.
        System.out.println("Root: "+document.getDocumentElement().getNodeName());
        //Yaptığımız for döngüsü ile nodelar arasında gezinmeye başlıyoruz.
        for (int i = 0; i <tree.getLength(); i++) {
            Node node = tree.item(i);
            //Node tipini kontrol ediyoruz.
            if (node instanceof Element){
                Element leaves=(Element) node;
                /*Ilk olarak getAttribute ile id isimli elemanın değerini alıyoruz, diğer elemanlarında 
                değerlerini alarak ekrana yazdırıyoruz*/
                System.out.println("Id:" + leaves.getAttribute("id"));
                System.out.println("Name:"+leaves.getElementsByTagName("ad").item(0).getTextContent());
                System.out.println("Surname:"+leaves.getElementsByTagName("soyAd").item(0).getTextContent());
                System.out.println("Salary:"+leaves.getElementsByTagName("maas").item(0).getTextContent());
            }
 
        }
 
    }

}
