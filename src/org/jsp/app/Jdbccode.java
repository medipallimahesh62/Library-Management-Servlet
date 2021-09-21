package org.jsp.app;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
class Jdbccode 
{
	public static String btitle;
	public static String bauthor;
	public static int bedition;
	public static double bprice;
	public static String btype;
	public static void addbookDetailsToDB(String title,String author,int edition,double price,String type)
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String query="insert into mahesh62.insertbook values(?,?,?,?,?)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2,author);
			preparedStatement.setInt(3, edition);
			preparedStatement.setDouble(4, price);
			preparedStatement.setString(5, type);
			preparedStatement.executeUpdate();
			connection.close(); 
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
	}
	public static void searchBook(String btitle)
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String query="select * from  mahesh62.insertbook where Booktitle=?";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1, btitle);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				 btitle=resultSet.getString("Booktitle");
			bauthor=resultSet.getString("Bookauthor");
				bedition=resultSet.getInt("Bookedition");
				 bprice=resultSet.getDouble("Bookprice");
				 btype=resultSet.getString("Booktype");
		System.out.println("book details :"+btitle+""+bauthor+""+bedition+""+bprice+""+btype);
		break;
			}
			
				
			
		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void updateBook(String btitle,String bauthor)
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String query="update mahesh62.insertbook set Booktitle=? where Bookauthor=?";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, btitle);
			preparedStatement.setString(2,bauthor);
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void removeBook(String bauthor)
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String sql="delete from mahesh62.insertbook where Bookauthor=?";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,bauthor);
			preparedStatement.executeUpdate();
			
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
