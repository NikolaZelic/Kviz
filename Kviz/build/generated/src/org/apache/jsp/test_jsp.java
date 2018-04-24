package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
 
   // Get session creation time.
   Date createTime = new Date(session.getCreationTime());
   
   // Get last access time of this Webpage.
   Date lastAccessTime = new Date(session.getLastAccessedTime());

   String title = "Welcome Back to my website";
   Integer visitCount = new Integer(0);
   String visitCountKey = new String("visitCount");
   String userIDKey = new String("userID");
   String userID = new String("ABCD");

   // Check if this is new comer on your Webpage.
   if (session.isNew() ){
      title = "Welcome to my website";
      session.setAttribute(userIDKey, userID);
      session.setAttribute(visitCountKey,  visitCount);
   } 
   visitCount = (Integer)session.getAttribute(visitCountKey);
   visitCount = visitCount + 1;
   userID = (String)session.getAttribute(userIDKey);
   session.setAttribute(visitCountKey,  visitCount);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("      <title>Session Tracking</title>\r\n");
      out.write("   </head>\r\n");
      out.write("   \r\n");
      out.write("   <body>\r\n");
      out.write("      <center>\r\n");
      out.write("         <h1>Session Tracking</h1>\r\n");
      out.write("      </center>\r\n");
      out.write("      \r\n");
      out.write("      <table border = \"1\" align = \"center\"> \r\n");
      out.write("         <tr bgcolor = \"#949494\">\r\n");
      out.write("            <th>Session info</th>\r\n");
      out.write("            <th>Value</th>\r\n");
      out.write("         </tr> \r\n");
      out.write("         <tr>\r\n");
      out.write("            <td>id</td>\r\n");
      out.write("            <td>");
 out.print( session.getId()); 
      out.write("</td>\r\n");
      out.write("         </tr> \r\n");
      out.write("         <tr>\r\n");
      out.write("            <td>Creation Time</td>\r\n");
      out.write("            <td>");
 out.print(createTime); 
      out.write("</td>\r\n");
      out.write("         </tr> \r\n");
      out.write("         <tr>\r\n");
      out.write("            <td>Time of Last Access</td>\r\n");
      out.write("            <td>");
 out.print(lastAccessTime); 
      out.write("</td>\r\n");
      out.write("         </tr> \r\n");
      out.write("         <tr>\r\n");
      out.write("            <td>User ID</td>\r\n");
      out.write("            <td>");
 out.print(userID); 
      out.write("</td>\r\n");
      out.write("         </tr> \r\n");
      out.write("         <tr>\r\n");
      out.write("            <td>Number of visits</td>\r\n");
      out.write("            <td>");
 out.print(visitCount); 
      out.write("</td>\r\n");
      out.write("         </tr> \r\n");
      out.write("      </table> \r\n");
      out.write("   \r\n");
      out.write("   </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}