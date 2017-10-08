package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import Article.ArticleConnection;


public class getArticleServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		int page = Integer.parseInt(request.getParameter("ipage"));
		ArticleConnection m = new ArticleConnection();
		List list = m.getArticle((page-1)*3,3);
		
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(list);
		PrintWriter pw = response.getWriter();
		pw.print(json);
	}

}
