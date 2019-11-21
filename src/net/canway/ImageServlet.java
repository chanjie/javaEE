package net.canway;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OutputStream out = resp.getOutputStream();

        //获取图片的输入流对象     "/"只能给Servlet的对象去使用才有着特殊的含义，  request response 。或者是给浏览器去使用。

        ServletContext servletContext = this.getServletContext();  //servletCOntext代表了当前的工程.
		/*String path = servletContext.getRealPath("/images/5.jpg"); // "/"就代表了day10工程，
		FileInputStream fileInputStream = new FileInputStream(path);*/


        InputStream fileInputStream  = servletContext.getResourceAsStream("/web_war_exploded/images/5.jpg"); //指定资源文件的名字获取资源文件的输入对象。

        byte[]  buf = new byte[1024];
        int length = 0 ;

        while((length = fileInputStream.read(buf))!=-1){
            out.write(buf,0,length);
        }
        fileInputStream.close();
    }
}
