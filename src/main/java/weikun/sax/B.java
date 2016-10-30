package weikun.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;
import sun.instrument.TransformerManager;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/10/29.
 */
public class B extends DefaultHandler{


    public static void main(String[] args) {
        new A().write();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始文档");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("结束文档");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println("开始元素"+qName);
        if(qName.equals("stu")){
            System.out.println("开始读取属性"+attributes.getQName(0)+":"+attributes.getValue("id"));
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("结束元素"+qName);
    }

    @Override//读取体的内容
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(new String(ch,start,length));
    }
    public void write(){
        SAXTransformerFactory stf=(SAXTransformerFactory)SAXTransformerFactory.newInstance();
        try {
            TransformerHandler th=stf.newTransformerHandler();

            Transformer t=th.getTransformer();
            t.setOutputProperty(OutputKeys.ENCODING,"utf-8");//允许存中文
            t.setOutputProperty(OutputKeys.INDENT,"yes");//允许缩进
            String filepath=A.class.getClassLoader().getResource("")+"stu4.xml";
            System.out.print(filepath);
            File file=new File(filepath.substring(6));


            FileOutputStream fos=new FileOutputStream(file);

            Result res=new StreamResult(fos);//使用res赋值

            th.setResult(res);
            th.startDocument();
            th.startElement(null,null,"YST",null);
            AttributesImpl ai=new AttributesImpl();

            ai.addAttribute(null,null,"id",null,"01");

            th.startElement(null,null,"stu",ai);

            th.startElement(null,null,"name",null);

            th.characters("张三".toCharArray(),0,"张三".length());

            th.endElement(null,null,"name");

            th.startElement(null,null,"sex",null);

            th.characters("男".toCharArray(),0,"男".length());

            th.endElement(null,null,"sex");


            th.endElement(null,null,"stu");
            th.endElement(null,null,"YST");

            th.endDocument();
            fos.flush();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


    }
    public void read(){

        SAXParserFactory spf=null;

//        String filepath=A.class.getClassLoader().getResource("").getPath();
//        System.out.print(filepath);

        InputStream is=A.class.getClassLoader().getResourceAsStream("stu1.xml");

        spf=SAXParserFactory.newInstance();
        try {
            SAXParser sp=spf.newSAXParser();

            sp.parse(is,new A());
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
        }
    }
}

