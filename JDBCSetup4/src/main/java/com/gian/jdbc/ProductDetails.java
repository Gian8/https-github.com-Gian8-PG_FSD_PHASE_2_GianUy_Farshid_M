package com.gian.jdbc;

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
		// TODO Auto-generated method stub
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties props=new Properties();
		props.load(in);
		try {
//			PrintWriter out=response.getWriter();
//			out.println("<html><body>");
//			

			
			DBConnection conn=new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
			Statement stmt=conn.getConnection().createStatement();
			String name = "Ford";
			String price = "128.85";
			
			stmt.executeUpdate("insert into eproduct (name,price,date_added) values('"+name+"',"+price+",now())");
			stmt.close();
			
			Statement stmt2=conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//stmt.executeUpdate("insert into eproduct(name, price, date_added) values('New Product', 800.00, now())");
			//stmt.executeUpdate("insert into eproduct (name, price, date_added) values('MonsterTruck', 999.09, now())");
			//out.println("Added MonsterTruck product<br>");
			//out.println("Execute an insert operation<br>");
			//stmt.executeUpdate("update eproduct set price=200.00 where name='New Product'");
			//out.println("Executed an update operation<br>");
			//stmt.executeUpdate("delete from eproduct where name='New Product'");
			//out.println("Executed a delete operation<br>");
			ResultSet rSet = stmt2.executeQuery("select * from eproduct");
			while(rSet.next()) {
				System.out.println(rSet.getInt("pid")+ "|"+rSet.getString("name")+"|"+rSet.getString("price"));
			}
			stmt2.close();
			conn.closeConnection();
//			out.println("</body></html>");
//			conn.closeConnection();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
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
