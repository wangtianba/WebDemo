<%@page contentType="text/html;charset=GBK"%> 
<html>   
<head><title>����Spring���HelloWorld</title></head>   
<%  
String str = (String)request.getAttribute("helloWorld");  
%> 
<body>   
<font size=��22��><%=str%></font>   
</body>   
</html> 