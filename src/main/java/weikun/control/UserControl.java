package weikun.control;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/29.
 */
@WebServlet(name="/userc",urlPatterns = {"/user"})
public class UserControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("username");

        String []names={"json","weikun","mike"};
        PrintWriter out=resp.getWriter();
        String result="false";
        for(String s :names){

            if(name.equals(s)){
                result="true";
                break;
            }
        }
        out.print(result);
        out.flush();
        out.close();

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
