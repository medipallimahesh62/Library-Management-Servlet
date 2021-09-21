package org.jsp.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/AddbookServlet")
public class AddbookServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String title=req.getParameter("title");
		String author=req.getParameter("author");
		String edition=req.getParameter("edition"); 
		String price1=req.getParameter("price");
		String type=req.getParameter("type");
		
		double bookprice=Double.parseDouble(price1);
		int edition1=Integer.parseInt(edition);
		
		Jdbccode.addbookDetailsToDB(title,author,edition1,bookprice,type);
		
		
	}
	
	

}
