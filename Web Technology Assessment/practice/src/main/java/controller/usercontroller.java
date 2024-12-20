package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.usermodel;
import Dao.Userdao;


/**
 * Servlet implementation class usercontroller
 */
@WebServlet("/usercontroller")
public class usercontroller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		
		if (action == null) {
			System.out.println("Action not found:!!!");
		}
		else {
			if(action.equalsIgnoreCase("Submit"))
			{
			  usermodel u=new usermodel();
			  u.setFname(request.getParameter("fname"));
			  u.setLname(request.getParameter("lname"));
			  u.setEmail(request.getParameter("email"));
			  u.setMobile(Long.parseLong(request.getParameter("mobile")));
			  u.setAddress(request.getParameter("address"));
			  u.setGender(request.getParameter("gender"));
			  u.setPass(request.getParameter("pass"));
			  u.setCpass(request.getParameter("cpass"));
			  System.out.println(u); 
			  Userdao.employeeadd(u);
			  request.getRequestDispatcher("view.jsp").forward(request, response);
			  
			}
			else if(action.equalsIgnoreCase("edit")) {
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println("User Id : "+ id);
				usermodel s1 = Userdao.getemployeeById(id);	
				request.setAttribute("data", s1);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}
			
			
			else if (action.equalsIgnoreCase("update")) {
				usermodel u = new usermodel();
				u.setId(Integer.parseInt(request.getParameter("id")));
				u.setFname(request.getParameter("fname"));
				u.setLname(request.getParameter("lname"));
				u.setEmail(request.getParameter("email"));
				u.setAddress(request.getParameter("address"));
				Userdao.updatemployee(u);
				response.sendRedirect("view.jsp");
			}
			
			else if(action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println("user id" + id);
				Userdao.deletemployee(id);
				response.sendRedirect("view.jsp");
				
			}
		  }
		
	}
}