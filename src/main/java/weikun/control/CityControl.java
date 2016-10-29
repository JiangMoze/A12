package weikun.control;

import com.alibaba.fastjson.JSON;
import weikun.vo.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/29.
 */
@WebServlet(name = "CityControl",urlPatterns = {"/city"})
public class CityControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pro=request.getParameter("pro");

        List<City> list=new ArrayList<City>();

        if(pro.equals("hlj")){
            list.add(new City("哈尔滨","hrb"));
            list.add(new City("绥化","sh"));
        }else  if(pro.equals("ln")){
            list.add(new City("沈阳","sy"));
            list.add(new City("大连","dl"));

        }else  if(pro.equals("hb")){
            list.add(new City("石家庄","sjz"));
            list.add(new City("保定","bd"));

        }else  if(pro.equals("hn")){
            list.add(new City("郑州","zz"));
            list.add(new City("开封","kf"));

        }

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out=response.getWriter();

        out.print(JSON.toJSONString(list,true));


        out.flush();
        out.close();
        System.out.print(JSON.toJSONString(list,true));

    }
}
