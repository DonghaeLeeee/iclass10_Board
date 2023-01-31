package org.iclass.dao;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;
import org.iclass.vo.CommunityComments;

import mybatis.SqlSessionBean;

public class CommunityDao {
	private static final CommunityDao dao = new CommunityDao();

	private CommunityDao() {
	}

	public static CommunityDao getInstance() {
		return dao;
	}

	public long insert(Community vo) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		mapperSession.insert("community.insert", vo);
		mapperSession.commit();
		mapperSession.close();
		return vo.getIdx();			//매퍼xml에서 selectKey 로 시퀀스 값을 vo 객체에 저장
	}

	public int update(Community vo) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.update("community.update", vo);
		mapperSession.commit();
		mapperSession.close();
		return result;
	}

	public int delete(int idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.delete("community.delete", idx);
		mapperSession.commit();
		mapperSession.close();
		return result;
	}
	
	public Community selectByIdx(int idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		Community vo = mapperSession.selectOne("community.selectByIdx",idx);
		mapperSession.commit();
		mapperSession.close();
		return vo;
		
	}
	
	
	
	//주요한 기능
	//전체 글의 갯수
	public int count() {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int vo = mapperSession.selectOne("community.count");
		mapperSession.close();
		return vo;
	}
	
	//읽은 메인글 조회수 증가
	public int setReadCount(int idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int vo = mapperSession.update("community.setReadCount",idx);
		mapperSession.commit();
		mapperSession.close();
		return vo;
	}

	//mref 메인글의 댓글 갯수
	public int commentsCount(int mref) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int vo = mapperSession.selectOne("community.commentsCount",mref);
		mapperSession.close();
		return vo;
	}
	
	//메인글의 댓글 갯수 업데이트
	public int setCommentCount(int mref) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int vo = mapperSession.selectOne("community.setCommentCount",mref);
		
		mapperSession.commit();
		mapperSession.close();
		return vo;
	}
	
}// class 종료
