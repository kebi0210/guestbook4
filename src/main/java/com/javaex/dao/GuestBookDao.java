package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;


@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;
		
	public List<GuestBookVo>getlist(){
		
	List<GuestBookVo> list	= sqlSession.selectList("guestbook.getlist");
		
		return list;
		
	}
	
	public void write(GuestBookVo vo) {
			
			sqlSession.insert("guestbook.write", vo);
	}
	
	public void delete(int no, String password) {
		
		Map<String,Object>map = new HashMap<String,Object>();
			
			map.put("no", no);
			map.put("password", password);
		
		sqlSession.delete("guestbook.delete", map);	
			
	}
}