package org.gian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
//		String userId = request.getParameter("uname");
//		String Password = request.getParameter("password");
//		if ("Gian" == userId) {
//			out.println("Please type in your username");
//		} else {
			response.sendRedirect("dashboard.html");
//		}
//		if (userId != null) {
//			out.println("Welcome! <br>");
//			response.sendRedirect("dashboard.html");
			
//		}
		//else if (userId == "Gian" && Password != "Hello") {
		//	out.println("Incorrect Password! Please go back and try again."+"<br>");
		//}
		//else if (userId != "Gian" && Password == "Hello") {
		//	out.println("Incorrect username! Please go back and try again."+"<br>");
		//}
//		else {
//			out.println("Incorrect username and Password!"+"<br>");
//		}
		out.println("</body></html>");
	}
	

}
