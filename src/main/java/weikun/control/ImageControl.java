package weikun.control;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/30.
 */
@WebServlet(name = "ImageControl",urlPatterns = {"/book"})
public class ImageControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookid=request.getParameter("bookid");
        Element root=new Element("books");
        if(bookid.equals("java")){


            Element book=new Element("book");


            Element name=new Element("name");

            name.setText("java编程大全");

            Element pic=new Element("pic");

            pic.setText("images/java.jpg");


            Element price=new Element("price");

            price.setText("20");

            book.addContent(name);
            book.addContent(pic);
            book.addContent(price);
            root.addContent(book);




        }else if(bookid.equals("jsp")){


            Element book=new Element("book");


            Element name=new Element("name");

            name.setText("jsp编程大全");

            Element pic=new Element("pic");

            pic.setText("images/jsp.jpg");


            Element price=new Element("price");
            price.setText("50");
            book.addContent(name);
            book.addContent(pic);
            book.addContent(price);
            root.addContent(book);
        }

        Document doc=new Document(root);
        XMLOutputter xmlout=new XMLOutputter();
        String xml=xmlout.outputString(doc);

        response.setCharacterEncoding("utf-8");

        response.setContentType("text/xml");

        PrintWriter out=response.getWriter();
        out.print(xml);

        out.flush();
        out.close();



    }
}
