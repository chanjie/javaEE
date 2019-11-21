<%--
  Created by IntelliJ IDEA.
  User: tonychen
  Date: 2019/11/19
  Time: 2:08 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Helloworld</title>
</head>
<body>
Hello ${student.name}, ${student.age}, ${student.gender}
<%
    int x = 10;
    out.println(x);
%>

<%!
    static
    {
        System.out.println("loading Servlet!");
    }
    private int globalVar = 0;
    public void jspInit()
    {
        System.out.println("initializing jsp!");
    }
%>
<%!
    public void jspDestroy()
    {
        System.out.println("destroying jsp!");
    }
%>
</body>
</html>
