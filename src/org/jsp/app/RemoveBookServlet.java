package org.jsp.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/RemoveBookServlet")
public class RemoveBookServlet extends GenericServlet
{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		
		String bauthor=req.getParameter("rba");
		Jdbccode.removeBook(bauthor);
		PrintWriter pw=res.getWriter();
		pw.println("Book details :"+ Jdbccode.btitle+ "" +Jdbccode.bauthor+ "" +Jdbccode.bedition+ "" +Jdbccode.bprice+ "" +Jdbccode.btype);
		
		
		
		
		
	}
	
	

}
