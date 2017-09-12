package org.lanqiao.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Messager;
import org.lanqiao.service.MsgService;
import org.lanqiao.service.MsgServiceImp;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize=2;
		int pageNum = request.getParameter("p") != null ? Integer.parseInt(request.getParameter("p")) : 1;

		String title=request.getParameter("title");
		String beginTime=request.getParameter("beginTime");
		String endTime=request.getParameter("endTime");
		HashMap<String, Object>searchMap=new HashMap<String, Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date bTime=null;
		Date eTime=null;	
			try {
				if(beginTime!=null && !beginTime.equals(""))
				bTime=sdf.parse(beginTime);
				  if(endTime!=null && !endTime.equals("")) 
			        	eTime=sdf.parse(endTime);
				  if(title.equals(""))
					  title=null;
				  else
					  title="%"+title+"%";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 searchMap.put("title", title);
		 searchMap.put("beginTime", bTime);
		 searchMap.put("endTime", eTime);
		 //分页
		 searchMap.put("beginNum", pageSize*(pageNum-1));
		 searchMap.put("pageSize", pageSize);
		
		MsgService msg=new MsgServiceImp();
		List<Messager>msgList=msg.searchMsg(searchMap);
		//封装对象
		request.setAttribute("mlist", msgList);
	    request.setAttribute("pageNum",pageNum);
	    request.setAttribute("maxPage", msg.getMaxPage(pageSize));
		request.getRequestDispatcher("message.jsp").forward(request, response); 
		
		 
		 
      
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
