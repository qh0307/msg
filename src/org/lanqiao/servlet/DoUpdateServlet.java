package org.lanqiao.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.StudentImp;
import org.lanqiao.entity.Student;

/**
 * Servlet implementation class DoUpdateServlet
 */
public class DoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String sname = request.getParameter("sname");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String classid = request.getParameter("classid");
		// 2
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int iid = (id != null && !id.equals("")) ? Integer.parseInt(id) : 0;
		Student stu = new Student(iid, sname, date, gender, Integer.parseInt(classid));
		// 3
		if (iid != 0) {
			int ret = new StudentImp().updatestudent(stu);
			// 4
			response.sendRedirect("ShowServlet?id=" + id);
		} else {
			int ret = new StudentImp().insertStudent(stu);
			response.sendRedirect("IndexServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost (HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
