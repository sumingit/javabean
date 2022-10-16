package com.my.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.project.dto.Calendar;
import com.my.project.repository.CalendarRepository;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarRepository calendarRepository;
	

	
	@Override
	public int calDrag(Calendar calendar) {
		
		return calendarRepository.calDrag(calendar);
	}



	@Override
	public List<Calendar> calList() {
	
		return calendarRepository.calList();
	}



	@Override
	public int calDelete(String title) {
		// TODO Auto-generated method stub
		return calendarRepository.calDelete(title);
	}

}
