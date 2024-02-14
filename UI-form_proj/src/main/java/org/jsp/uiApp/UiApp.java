package org.jsp.uiApp;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/fs") 
// for annotation configaturation delete web.xml only and rename html to index
//for web.xml generate web.xml
/** <?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" version="4.0">
  <display-name>UI-form_proj</display-name>
  <welcome-file-list>
    <welcome-file>Form.html</welcome-file>
  </welcome-file-list>
  
  <servlet-mapping>
  <servlet-name>UiApp</servlet-name>
  <url-pattern>/fs</url-pattern>
  </servlet-mapping>
  
  <servlet>
  <servlet-name>UiApp</servlet-name>
  <servlet-class>org.jsp.uiApp.UiApp</servlet-class>
  </servlet>
  
</web-app>*/
public class UiApp extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		//fetch ui/form data 
		String name = req.getParameter("nm");
		String place= req.getParameter("pl");
		
		//presentation logic
		
		PrintWriter out = resp.getWriter();
		out.println("<html> <body bgcolor='cyan'>"
				+"<h1>Student name is "+ name +" from "+ place + "</h1>"
				+"</body></html>");
		
		out.close();

	}

}
