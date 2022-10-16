package com.my.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.project.dto.Calendar;
import com.my.project.service.CalendarService;


@Controller
public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	
	@RequestMapping("calendar")
	public void calendar() {}
	
	
	@ResponseBody
	@RequestMapping("caldata")
	public List<Map<String, Object>> caldata(@ModelAttribute Calendar calendar, Model model
			, RedirectAttributes rattr) throws Exception {
		
        JSONObject jsonObj = new JSONObject();
        JSONArray jsonArr = new JSONArray();
        

		HashMap<String, Object> hashmap = new HashMap<>();
		List<Calendar> clist = calendarService.calList();
		
		
		
		//기간선택
		for(Calendar cal : clist) {
			hashmap.put("title", cal.getTitle());
			hashmap.put("start", cal.getStart());
			hashmap.put("end", cal.getEnd());
			hashmap.put("allDay", true); 
			
	        jsonObj = new JSONObject(hashmap);
	        jsonArr.add(jsonObj);
		}
		

		System.out.println(jsonArr);
		
		
		
		return jsonArr ;
	}
	
	@ResponseBody
	@RequestMapping("drag")
	public String calinsert(@RequestBody Calendar calendar) throws Exception {

		System.out.println(calendar);	
		 calendarService.calDrag(calendar); 
		 

		return "okok";

	}
	
	  @ResponseBody 
	  @DeleteMapping("/{title}")
	  public String caldelete(@PathVariable String title) throws Exception {
		  
			  System.out.println(title);
			  calendarService.calDelete(title);
	
		  
		  return "delete!";
	  
	  }
	 
	
	
}
