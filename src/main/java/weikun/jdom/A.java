package weikun.jdom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public class A {
    public static void main(String[] args) {
        new A().read();
    }
    public void read(){
        try {
            SAXBuilder sax=new SAXBuilder();

            Document doc=sax.build(A.class.getClassLoader().getResourceAsStream("stu1.xml"));

            Element root=doc.getRootElement();
            System.out.println(root.getName());

            List<Element> list=root.getChildren();
            for(Element ele :list){

                System.out.printf("%s\n",ele.getName());
                System.out.printf("%s\n",ele.getAttributeValue("id"));

                List<Element>  c=ele.getChildren();

                for(Element e :c){
                    System.out.printf("%s\n",e.getText());

                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {


        }


    }

    public void write(){

        Element root=new Element("YST");

        Element stu=new Element("stu");

        stu.setAttribute("id","1");


        Element name=new Element("name");

        name.setText("你好");


        Element sex=new Element("sex");

        sex.setText("女");


        stu.addContent(name);
        stu.addContent(sex);

        root.addContent(stu);

        Document doc=new Document(root);

        try {
            String filepath=A.class.getClassLoader().getResource("").getPath();

            File file=new File(filepath+"stu1.xml");
            FileOutputStream fos=new FileOutputStream(file);

            XMLOutputter out=new XMLOutputter();

            out.output(doc,fos);

            System.out.println(out.outputString(doc));
            fos.flush();
            fos.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
