<%@page contentType="text/html;charset=GBK"%> 
<html>   
<head><title>ÀûÓÃSpringÊä³öHelloWorld</title></head>   
<%  
String str = (String)request.getAttribute("helloWorld");  
%> 
<body>   
<font size=¡¯22¡¯><%=str%></font>   
</body>   
</html> 