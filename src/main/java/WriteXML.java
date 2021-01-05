import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Description:
 * @Author : 郑润楷
 * @Date : 2021-01-05 17:38
 **/
public class WriteXML {
    public static void main(String[] args) throws IOException {
//        通过DocumentHelper生成一个Document对象
        Document doc = DocumentHelper.createDocument();
//        可以直接链式添加
//        doc.addElement("books").addElement("book").addElement("id","001");
//        添加并得到根元素、子元素
        Element root=doc.addElement("books");
        Element book=root.addElement("book");
//        为book元素添加属性、子元素
        book.addAttribute("id","001");
        Element name = book.addElement("name");
        Element author = book.addElement("author");
        Element price = book.addElement("price");
//        为子元素添加文本
        name.addText("水浒传");
        author.addText("施耐庵");
        price.addText("88");
//        将doc输出到xml文件
//        Writer writer=new FileWriter(new File("./src/main/java/xml/write.xml"));
//        doc.write(writer);
////        关闭资源
//        writer.close();
//        美化输出（格式化）
        OutputFormat print = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileWriter(new File("src/main/java/xml/write.xml")),print);
        writer.write(doc);
        writer.close();
    }
}
