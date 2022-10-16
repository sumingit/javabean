package com.my.project.repository;

import java.util.List;
import com.my.project.dto.Calendar;

public interface CalendarRepository {


	int calDrag(Calendar calendar);
	List<Calendar> calList();
	int calDelete(String title);
}
