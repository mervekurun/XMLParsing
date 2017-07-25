/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAX;


import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.SAXParser;
import java.lang.Object;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author HP PAVİLİON 15
 */
public class SAXParsers {

   public static void main(String[] args) {
   
      // Çözümleme işlemi için bir SAXParserFactory oluşturuyoruz.
      SAXParserFactory factory = SAXParserFactory.newInstance();
      // Handler oluşturuyoruz.HandlerBase handler = new HandlerBase()
      DefaultHandler handler =new DefaultHandler()
       {
         // Parser'ın karakter görünce yazdırmasını sağlayacak bir metod oluşturuyoruz.
         public void characters(char[] ch, int start, int length) {
            // Karakteri yazdırıyoruz
            System.out.println("" + new String(ch, start, length));
         }
      };
      try {
         // Bir input stream oluşturarak XML dosyasını alıyoruz.
         FileInputStream fis = new FileInputStream("file.xml");
         /*Input Source bir ortak tanıtıcı, bir sistem tanımlayıcı, bir bayt akışı ve / veya bir
         karakter akışı içerebilen bir girdi kaynağını tek nesnede kapsülleyen bir elemandır.
         SAX ayrıştırıcısı, XML girdisinin nasıl okunacağını belirlemek için InputSource nesnesini kullanır*/
         InputSource is = new InputSource(fis);
         // Yeni bir SaxParser nesnesi oluşturuyoruz.
         SAXParser parser = factory.newSAXParser();
         // Oluşturduğumuz parser nesnesini InputSource ve handler nesnesi ile parse ediyoruz.
         parser.parse(is, handler);

      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
} 


