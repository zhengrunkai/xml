import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * @Description:
 * @Author : 郑润楷
 * @Date : 2021-01-05 17:11
 **/
public class ReadXML {
    public static void main(String[] args) throws DocumentException {
//        创建SAXReader对象，用于读取xml文件
        SAXReader reader=new SAXReader();
//        读取xml文件，得到Document对象
        Document doc=reader.read(new File("src/main/java/xml/read.xml"));
//        获取根元素
        Element root = doc.getRootElement();
        System.out.println(root.getName());
//        获取根元素下所有子元素
        Iterator<Element> it = root.elementIterator();
        while(it.hasNext()){
//            取出元素
            Element e = it.next();
            System.out.println(e.getName());
//            获取id属性
            Attribute id = e.attribute("id");
            System.out.println(id.getName()+"="+id.getValue());
//        获取stu子元素
            Element name = e.element("name");
            Element sex = e.element("sex");
            Element age = e.element("age");
            System.out.println(name.getName()+"="+name.getStringValue());
            System.out.println(sex.getName()+"="+sex.getStringValue());
            System.out.println(age.getName()+"="+age.getStringValue());
        }
    }
}
