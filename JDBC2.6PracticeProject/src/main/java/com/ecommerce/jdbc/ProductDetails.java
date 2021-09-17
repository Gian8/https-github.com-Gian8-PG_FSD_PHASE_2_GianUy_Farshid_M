package com.ecommerce.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties props=new Properties();
		props.load(in);
		try {
//			PrintWriter out=response.getWriter();
//			out.println("<html><body>");
			String itemName = request.getParameter("ItemName");
			String itemPrice = request.getParameter("ItemPrice");
			
			DBConnection conn=new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
			Statement stmt=conn.getConnection().createStatement();
	//		stmt.executeUpdate("insert into eproduct(name,price,date_added) values('iPhone',999.99,now())");
			stmt.executeUpdate("insert into eproduct (name,price,date_added) values('"+itemName+"',"+itemPrice+",now())");
			stmt.close();
			Statement stmt2=conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rst=stmt2.executeQuery("select * from eproduct");
			while (rst.next()) {
				System.out.println(rst.getInt("pid")+","+rst.getString("name"));
			}
			stmt2.close();
//			out.println("</body></html>");
			conn.closeConnection();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
