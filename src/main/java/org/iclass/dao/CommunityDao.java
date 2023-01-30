package org.iclass.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;

import mybatis.SqlSessionBean;

public class CommunityDao {
	private static final CommunityDao dao = new CommunityDao();

	private CommunityDao() {
	}
	
	public static CommunityDao getInstance() {
		return dao;
	}
	
	public int insert(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("insert",vo);
		
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int update(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("update",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int delete(String id) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("delete",id);
		mapper.commit();
		mapper.close();
		return result;
	}
	
	
	
}//class 종료

