/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.53
 * Generated at: 2021-11-16 15:35:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.text.*;
import classes.*;

public final class index_005f2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("classes");
    _jspx_imports_packages.add("javax.sql");
    _jspx_imports_packages.add("javax.naming");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      classes.BbsArticleList articleList = null;
      articleList = (classes.BbsArticleList) _jspx_page_context.getAttribute("articleList", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (articleList == null){
        articleList = new classes.BbsArticleList();
        _jspx_page_context.setAttribute("articleList", articleList, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>掲示板</title>\n");
      out.write("    \n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"\n");
      out.write("      integrity=\"sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\n");
      out.write("      integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\n");
      out.write("     integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/main.js\"></script>\n");
      out.write("    \n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("    integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\n");
      out.write("    crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\">\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <h2 class=\"mt-4 font-weight-bold\">【掲示板】</h2>\n");
      out.write("      <hr/>\n");
      out.write("    <div class=\"d-flex flex-row\">\n");
      out.write("      <div><a href=\"write_1.jsp\" class=\"h5 indexP_writeAnchor\">投稿する</a></div>\n");
      out.write("      <div class=\"ml-5\">ここにページネーション</div>\n");
      out.write("    </div>\n");
      out.write("      <hr/>\n");
      out.write("      ");

      articleList.makeList();
      /* Context context = new InitialContext();
      DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jamyto2");
      Connection conn = ds.getConnection();
      Statement stmt = conn.createStatement();
      String strSql = "SELECT * FROM bbs ORDER BY id";
      ResultSet rs = stmt.executeQuery(strSql);
      DateFormat df = new SimpleDateFormat("yyyy'年'MM'月'dd'日' E'曜日' HH'時'mm'分'");
      java.util.Date date = new java.util.Date();
      java.util.Date editDate = new java.util.Date(); */
      while(articleList.next()) {
        BbsArticle article = articleList.getArticle();
        DateFormat df = new SimpleDateFormat("yyyy'年'MM'月'dd'日' E'曜日' HH'時'mm'分'");
      /* while(rs.next()) {
      long lngDateTime = rs.getLong("date_time");
      date.setTime(lngDateTime);
      long lngEditDateTime = rs.getLong("edit_date_time");
      editDate.setTime(lngEditDateTime); */
      
      out.write("\n");
      out.write("      <table>\n");
      out.write("        <tr>\n");
      out.write("          <td>【番号】</td>\n");
      out.write("          <td>");
      out.print( article.getId() );
      out.write("\n");
      out.write("          ");
 if(article.getPswdSet()) { 
      out.write("\n");
      out.write("          <a style=\"margin-left:10px;\" href=\"delete_1.jsp?id=");
      out.print( article.getId() );
      out.write("\">[削除]</a>\n");
      out.write("          <a style=\"margin-left: 5px;\" href=\"edit_1.jsp?id=");
      out.print( article.getId() );
      out.write("\">[編集]</a>\n");
      out.write("          ");
 } 
      out.write("\n");
      out.write("          </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td>【日時】</td>\n");
      out.write("          <td class=\"small\" style=\"font-style: italic\">");
      out.print( df.format(article.getDateTime()) );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 if(article.getEditDatetime() != 0) { 
      out.write("\n");
      out.write("        <tr class=\"text-secondary\">\n");
      out.write("          <td></td>\n");
      out.write("          <td class=\"small\" style=\"font-style: italic\">");
      out.print( df.format(article.getEditDatetime()) );
      out.write("　更新</td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        <tr>\n");
      out.write("          <td>【名前】</td>\n");
      out.write("          <td class=\"text-info font-weight-bold\">");
      out.print( TextConv.beforeHtml(article.getAuthor()) );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td>【件名】</td>\n");
      out.write("          <td>");
      out.print(  TextConv.beforeHtml(article.getSubject()) );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr style=\"vertical-align: top;\">\n");
      out.write("          <td>【本文】</td>\n");
      out.write("          <td>");
      out.print( TextConv.embedLink(TextConv.beforeHtml(article.getBody())) );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("      </table>\n");
      out.write("      <hr/>\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("      <div id=\"writeAnchorBtn\">\n");
      out.write("        <a href=\"write_1.jsp\" class=\"toggleWanchor btn btn-primary btn-lg rounded-pill border border-info\">投稿する</a>\n");
      out.write("      </div>\n");
      out.write("      <div>ここにページネーション</div>\n");
      out.write("    </div>\n");
      out.write("    <hr/>\n");
      out.write("  \n");
      out.write("    <div class=\"container-fluid footer\">\n");
      out.write("      <hr/>\n");
      out.write("      <div class=\"row justify-content-center\">\n");
      out.write("        <p class=\"mt-3\"><b>Copyright - M-Watanabe, 2021.11 ~</b></p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <hr/>\n");
      out.write("  \n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
