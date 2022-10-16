package com.my.project.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.project.dto.Calendar;


@Repository
public class CalendarRepositoryImpl implements CalendarRepository {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int calDrag(Calendar calendar) {
		
		return sqlSession.insert("com.my.project.CalendarMapper.insert", calendar);
	}


	@Override
	public List<Calendar> calList() {
		
		return sqlSession.selectList("com.my.project.CalendarMapper.selectList");
	}
	@Override
	public int calDelete(String title) {
		
		return sqlSession.delete("com.my.project.CalendarMapper.delete", title);
	}

}
