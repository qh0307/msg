package org.lanqiao.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Messager;
import org.lanqiao.service.MsgService;
import org.lanqiao.service.MsgServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MsgController {
   @Autowired
	MsgService msgService;
	
	       @RequestMapping("/getMsgByPage")
           public String getMsgByPage(String P ,Model model){
        	   int pageSize=2;
        	   if(P==null) {
       			P="1";
       		}
        		List<Messager>mList=msgService.getMessagerByPage(pageSize,Integer.parseInt(P));
        		//封装对象
        		model.addAttribute("mlist", mList);
        	    model.addAttribute("pageNum", Integer.parseInt(P));
        	    model.addAttribute("maxPage", msgService.getMaxPage(pageSize));
        	    
        	    return "message";
        	   
           }
	         @RequestMapping("/addMesg")
	       public String addMsg(String author,String message,Messager messager) {
			
	        	   messager.setName(author);
	     	       messager.setContent(message);
	     	       messager.setDate(new Date());
	     
	     	       int ret=msgService.addMsg(messager);
	     	        return "forward:getMsgByPage";
	    	   
	       }
	         @RequestMapping("/searchMsg")
	         public String searchMsg(@RequestParam Map<String,Object>map,String P, String title,String beginTime,String endTime, Model model) {
				
				int pageSize=2;
//				String title=(String) map.get("title");
//				Date beginTime=(Date) map.get("beginTime");
//				Date endTime=(Date) map.get("endTime");
//				HashMap<String, Object>searchMale=p=new HashMap<String, Object>();
				if(title!=null && !title.equals("")) {
					title="%"+title+"%";
				}else {
					title=null;
				}
				if(beginTime.equals(""))
					beginTime=null;
				if(endTime.equals(""))
					endTime=null;
				
				map.put("title", title);
				map.put("beginTime", beginTime);
				map.put("endTime", endTime);
//				 //分页
//				 searchMap.put("beginNum", pageSize*(Integer.parseInt(P)-1));
//				 searchMap.put("pageSize", pageSize);
//				
		
				List<Messager>msgList=msgService.searchMsg(map);
				//封装对象
				model.addAttribute("mlist", msgList);
//			    model.addAttribute("pageNum",P);
//			    model.addAttribute("maxPage", msgService.getMaxPage(pageSize));
			    return "message";
				
	         }
	         
	         
	         
	       
	       

}
