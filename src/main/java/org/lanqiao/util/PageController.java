package org.lanqiao.util;

public class PageController {
	public static String createPageCode(int pageNum,int maxPage,String url) {
		int prePage=pageNum==1? 1:pageNum-1;
		int nexPage=pageNum==maxPage?maxPage:pageNum+1;
		String str="<a href=\""+url+"?P=1\">首页</a>"
	         	  +"<a href=\""+url+"?P="+prePage+"\">上一页</a> "
	         	  +"<a href=\""+url+"?P="+nexPage+"\">下一页</a> "
	         	  +"<a href=\""+url+"?P="+maxPage+"\">尾页</a> ";
		return str;
	}
	}
	
