package org.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.StudentDao;
import org.lanqiao.dao.StudentImp;
import org.lanqiao.entity.Student;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pageSize = 2;
		// 获取数据
		String pageNum = request.getParameter("P");
		if (pageNum == null) {
			pageNum = "1";
		}
		// 调用gdao
		StudentDao studao = new StudentImp();
		List<Student> stuList = studao.getstudentByPage(pageSize, Integer.parseInt(pageNum));
		int maxPage = studao.getMaxPage(pageSize);
		// 封装对象
		request.setAttribute("list", stuList);
		request.setAttribute("pageNum", Integer.parseInt(pageNum));
		request.setAttribute("maxPage", maxPage);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
