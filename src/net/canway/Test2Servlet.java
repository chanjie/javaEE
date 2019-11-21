package net.canway;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class Test2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求方式
        String method = request.getMethod();
        //获取请求的url路径
        String url = request.getRequestURI();
        //获取协议的版本
        String protocl = request.getProtocol();

        System.out.println("请求的方式："+method+" 请求的路径："+ url+" 使用的协议："+protocl);

        System.out.println("username: " + request.getParameter("username"));

        /*
		  Content-EnCondig的作用： 通知浏览器解压当前的数据，然后再显示当前的数据。
		 */
        response.setHeader("Content-Encoding", "gzip");
        //创建 一个StringBuilder
        StringBuilder sb  = new StringBuilder();
        for(int i = 0 ; i<1000 ; i++){
            sb.append("abcd");
        }
        OutputStream outputStream = 	response.getOutputStream();
        //输出流的压缩类
        GZIPOutputStream   gzipOutputStream = new GZIPOutputStream(outputStream);
		/*
		GZIPOutputStream的作用是把数据压缩，不具备数据写出的能力。
		使用GZIPOutputStream的write方法时候，GZIPOutputStream首先会对这些数据进行压缩，压缩完成
		之后就会调用你传入进来的输出流对象，把压缩的数据写出。
		*/
        gzipOutputStream.write(sb.toString().getBytes());

        //使用gzipOutputStream的 write方法的时候数据其实会先驻留在缓存中，并没有 真正的写出。只要你调用了finish();

        gzipOutputStream.finish();
    }
}
