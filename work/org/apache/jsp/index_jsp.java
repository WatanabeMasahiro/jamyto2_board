/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.53
 * Generated at: 2021-11-24 07:35:56 UTC
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

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("      integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/main.js\"></script>\n");
      out.write("    \n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("      integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\n");
      out.write("      crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\">\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <h2 class=\"mt-4 font-weight-bold\">【掲示板】</h2>\n");
      out.write("      <hr/>\n");
      out.write("	    <div class=\"d-flex flex-row\">\n");
      out.write("	      <div class=\"mr-5 ml-2\">\n");
      out.write("	        <a href=\"write_1.jsp\" class=\"d-inline h5 indexP_writeAnchor\">投稿する</a>\n");
      out.write("	      </div>\n");
      out.write("	      <div>\n");
      out.write("	        <form method=\"POST\" action=\"search.jsp\" class=\"form-inline ml-5\">\n");
      out.write("            <input type=\"text\" name=\"search\" class=\"mr-1 w-50\">\n");
      out.write("            <input type=\"submit\" value=\"検索\" class=\"btn btn-secondary btn-sm border border-dark\">\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("			</div>\n");
      out.write("			<hr class=\"mb-1\"/>\n");
      out.write("			<div class=\"ml-1\">\n");
      out.write("      ");

      articleList.setLimit(10);  // 表示行数/ページ
      int intPage;
      String strJumpTo = request.getParameter("jump_to");
      String strPage = request.getParameter("page");
      if(strJumpTo != null) {
    	  intPage = articleList.getPageFromId(Integer.parseInt(strJumpTo));
      } else if(strPage != null) {
        intPage = Integer.parseInt(strPage);
      } else {
    	  intPage = articleList.getLastPage();
      }
      articleList.setPage(intPage);

      if(intPage > 1) { 
      out.write("\n");
      out.write("          <a href=\"index.jsp?page=");
      out.print( intPage -1 );
      out.write("\" class=\"mr-3\">前のページ</a>\n");
      out.write("      ");
 }
      for(int i=1; i<=articleList.getLastPage(); i++) {
    	  if(i != intPage) { 
      out.write("\n");
      out.write("    		  <a href=\"index.jsp?page=");
      out.print( i );
      out.write("\" class=\"mx-1\">");
      out.print( i );
      out.write("</a>\n");
      out.write("    		");
 } else { 
      out.write("\n");
      out.write("    			<span>【");
      out.print( i );
      out.write("】</span>\n");
      out.write("    	");
 }
      }
      if(articleList.getLastPage() > intPage) { 
      out.write("\n");
      out.write("          <a href=\"index.jsp?page=");
      out.print( intPage +1 );
      out.write("\" class=\"ml-3\">次のページ</a>\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("      </div>\n");
      out.write("			<hr class=\"mt-1\"/>\n");
      out.write("      ");

      DateFormat df = new SimpleDateFormat("yyyy'年'MM'月'dd'日' E'曜日' HH'時'mm'分'");
      articleList.setParentId(0);   //  親Id
      articleList.makeList();
      while(articleList.next()) {
        BbsArticle article = articleList.getArticle();
      
      out.write("\n");
      out.write("      <a id=\"anc");
      out.print( article.getId() );
      out.write("\"></a>\n");
      out.write("      <table style=\"border-collapse:separate; border-spacing: 0 5px;\">\n");
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
      out.write("        <tr style=\"vertical-align: top;\">\n");
      out.write("          <td>【名前】</td>\n");
      out.write("          <td class=\"text-info font-weight-bold bg-white p-1 rounded\" style=\"width: 250px; word-break: break-all;\">");
      out.print( TextConv.beforeHtml(article.getAuthor()) );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr style=\"vertical-align: top;\">\n");
      out.write("          <td>【件名】</td>\n");
      out.write("          <td class=\"bg-white bgwhiteNo1 p-1 rounded\" style=\"width: 250px; word-break: break-all;\">");
      out.print( TextConv.beforeHtml(article.getSubject()) );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr style=\"vertical-align: top;\">\n");
      out.write("          <td>【本文】</td>\n");
      out.write("          <td class=\"bg-white bgwhiteNo2 p-1 pb-4 rounded\" style=\"width: 250px; word-break: break-all;\">");
      out.print( TextConv.embedLink(TextConv.beforeHtml(article.getBody())) );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("      </table>\n");
      out.write("      <div class=\"mt-3\">\n");
      out.write("        <a href=\"write_1.jsp?parent_id=");
      out.print( article.getId() );
      out.write("\" style=\"text-decoration: underline;\">コメントを書く</a>\n");
      out.write("      </div>\n");
      out.write("      <hr/>\n");
      out.write("	      ");

	      classes.BbsArticleList children = new classes.BbsArticleList();
	      children.setParentId(article.getId());  //  子Id
	      children.makeList();
	      while(children.next()) {
	    	  BbsArticle child = children.getArticle();
	    	
      out.write("\n");
      out.write("	    	\n");
      out.write("	    	  <a id=\"anc");
      out.print( child.getId() );
      out.write("\"></a>\n");
      out.write("		      <table style=\"border-collapse:separate; border-spacing: 0 5px;\" class=\"ml-5\">\n");
      out.write("		        <tr>\n");
      out.write("		          <td colspan=\"2\" class=\"text-danger small\">>>");
      out.print( article.getId() );
      out.write("</td>\n");
      out.write("		        </tr>\n");
      out.write("		        <tr>\n");
      out.write("		          <td>【番号】</td>\n");
      out.write("		          <td>");
      out.print( child.getId() );
      out.write("\n");
      out.write("		          ");
 if(child.getPswdSet()) { 
      out.write("\n");
      out.write("		          <a style=\"margin-left:10px;\" href=\"delete_1.jsp?id=");
      out.print( child.getId() );
      out.write("\">[削除]</a>\n");
      out.write("		          <a style=\"margin-left: 5px;\" href=\"edit_1.jsp?id=");
      out.print( child.getId() );
      out.write("\">[編集]</a>\n");
      out.write("		          ");
 } 
      out.write("\n");
      out.write("		          </td>\n");
      out.write("		        </tr>\n");
      out.write("		        <tr>\n");
      out.write("		          <td>【日時】</td>\n");
      out.write("		          <td class=\"small\" style=\"font-style: italic\">");
      out.print( df.format(child.getDateTime()) );
      out.write("</td>\n");
      out.write("		        </tr>\n");
      out.write("		        ");
 if(child.getEditDatetime() != 0) { 
      out.write("\n");
      out.write("		        <tr class=\"text-secondary\">\n");
      out.write("		          <td></td>\n");
      out.write("		          <td class=\"small\" style=\"font-style: italic\">");
      out.print( df.format(child.getEditDatetime()) );
      out.write("　更新</td>\n");
      out.write("		        </tr>\n");
      out.write("		        ");
 } 
      out.write("\n");
      out.write("		        <tr>\n");
      out.write("		          <td>【名前】</td>\n");
      out.write("		          <td class=\"text-info font-weight-bold bg-white p-1 rounded\" style=\"width: 250px; word-break: break-all;\">");
      out.print( TextConv.beforeHtml(child.getAuthor()) );
      out.write("</td>\n");
      out.write("		        </tr>\n");
      out.write("		        <tr>\n");
      out.write("		          <td>【件名】</td>\n");
      out.write("		          <td class=\"bg-white bgwhiteNo1 p-1 rounded\" style=\"width: 250px; word-break: break-all;\">");
      out.print( TextConv.beforeHtml(child.getSubject()) );
      out.write("</td>\n");
      out.write("		        </tr>\n");
      out.write("		        <tr style=\"vertical-align: top;\">\n");
      out.write("		          <td>【本文】</td>\n");
      out.write("		          <td class=\"bg-white bgwhiteNo2 p-1 pb-4 rounded\" style=\"width: 250px; word-break: break-all;\">");
      out.print( TextConv.embedLink(TextConv.beforeHtml(child.getBody())) );
      out.write("</td>\n");
      out.write("		        </tr>\n");
      out.write("		      </table>\n");
      out.write("		      <!-- <div class=\"mt-3\">\n");
      out.write("		        <a href=\"write_1.jsp?parent_id=<％= /* child.getId() */ ％>\" style=\"text-decoration: underline;\">コメントを書く</a>\n");
      out.write("		      </div> -->\n");
      out.write("		      <hr/>\n");
      out.write("	    	\n");
      out.write("	    	");
 }
      } 
      out.write("\n");
      out.write("      <div class=\"ml-1\">\n");
      out.write("	      <div id=\"writeAnchorBtn\">\n");
      out.write("	        <a href=\"write_1.jsp\" class=\"toggleWanchor btn btn-primary btn-lg rounded-pill border border-info\">投稿する</a>\n");
      out.write("	      </div>\n");
      out.write("	      ");

	      if(intPage > 1) { 
      out.write("\n");
      out.write("	      <a href=\"index.jsp?page=");
      out.print(intPage-1);
      out.write("\" class=\"mr-3\">前のページ</a>\n");
      out.write("				");
 }
				for(int i=1; i<=articleList.getLastPage(); i++) {
				  if(i != intPage) { 
      out.write("\n");
      out.write("			      <a href=\"index.jsp?page=");
      out.print( i );
      out.write("\" class=\"mx-1\">");
      out.print( i );
      out.write("</a>\n");
      out.write("			    ");
 } else { 
      out.write("\n");
      out.write("			      【");
      out.print( i );
      out.write("】\n");
      out.write("				");
 }
				}
				if(articleList.getLastPage() > intPage) { 
      out.write("\n");
      out.write("			    <a href=\"index.jsp?page=");
      out.print(intPage+1);
      out.write("\" class=\"ml-3\">次のページ</a>\n");
      out.write("				");
 } 
      out.write("\n");
      out.write("			</div>\n");
      out.write("    </div>\n");
      out.write("    <hr/>\n");
      out.write("\n");
      out.write("    <div class=\"container-fluid footer\">\n");
      out.write("      <hr/>\n");
      out.write("      <div class=\"row justify-content-center\">\n");
      out.write("        <p class=\"mt-3\"><b>Copyright - M-Watanabe, 2021.11 ~</b></p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <hr/>\n");
      out.write("\n");
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
