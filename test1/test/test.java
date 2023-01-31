package test;

import static org.junit.Assert.assertEquals;

import org.iclass.dao.CommunityCommentsDao;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class test {

	CommunityDao communityDao = CommunityDao.getInstance();
	CommunityCommentsDao commentsDao = CommunityCommentsDao.getInstance();
	
//	@DisplayName("메인글 쓰기 insert")
//	@Test
//	void insertMain() {
//		Community vo = Community.builder().writer("트트트").title("자바정석 후기").content("자바 공부하기 자바 정석으로").build();
//		communityDao.insert(vo);
//		assertEquals(vo.getIdx(), 26); // 기대값 : 생성된 시퀀스값
//	}

	
	@DisplayName("댓글 조회수 증가")
	@Test
	void setReadCount() {
		int vo = new Community().getReadcount();
		communityDao.setReadCount(3);
		assertEquals(vo, 1);
	}

	
	
}


