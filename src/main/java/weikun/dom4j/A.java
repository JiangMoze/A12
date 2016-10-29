package weikun.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
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
            BufferedReader br=new BufferedReader(new InputStreamReader(A.class.getClassLoader().getResourceAsStream("stu2.xml")));

            StringBuffer sb=new StringBuffer();
            String line="";
            while((line=br.readLine())!=null){

                sb.append(line);

            }

            Document doc=DocumentHelper.parseText(sb.toString());
            Element root=doc.getRootElement();
            System.out.println(root.getName());

            List <Element>list=root.elements();

            for( Element ele :list){
                System.out.println(ele.getName());
                System.out.println(ele.attributeValue("id"));

                List<Element> l=ele.elements();

                for(Element e :l){
                    System.out.println(e.getName());
                    System.out.println(e.getTextTrim());

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


    }
    public void write(){
        try {
            OutputFormat of=OutputFormat.createPrettyPrint();
            of.setEncoding("utf-8");
            of.setIndentSize(4);//缩进

            Document doc=DocumentHelper.createDocument();

            Element root=doc.addElement("YST");

            Element stu=root.addElement("stu");

            stu.setAttributeValue("id","1");

            Element name=stu.addElement("name");

            name.setText("张珊");

            Element sex=stu.addElement("sex");

            sex.setText("男");
            String filepath=A.class.getClassLoader().getResource("").getPath();
            FileOutputStream fos=new FileOutputStream(filepath+"stu2.xml");
            XMLWriter w=new XMLWriter(fos,of);

            w.write(doc);

            System.out.print(doc.asXML());
            w.flush();
            w.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


    }
}
