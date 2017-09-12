package org.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.ClassDaoImp;
import org.lanqiao.dao.StudentDao;
import org.lanqiao.dao.StudentImp;
import org.lanqiao.entity.Classes;
import org.lanqiao.entity.Student;

/**
 * Servlet implementation class ShowServlrt
 */
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		   if(id!=null) {
			  
			   Student sd= new StudentImp().getStuById(id);
			   request.setAttribute("stu", sd);
		   }
	  
		   List<Classes>classList=new ClassDaoImp().getClassesList();
	   	   request.setAttribute("classList", classList);
	       request.getRequestDispatcher("show.jsp").forward(request, response);   
	   
	      
	   
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
