package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.iclass.dao.CommunityCommentsDao;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

	CommunityDao communityDao = CommunityDao.getInstance();
	CommunityCommentsDao commentsDao = CommunityCommentsDao.getInstance();
	
//	@DisplayName("메인글 쓰기 insert")
//	@Test
//	void insertMain() {
//		Community vo = Community.builder().writer("하위").title("자바정석 후기").content("자바 공부하기 자바 정석으로").build();
//		communityDao.insert(vo);
//		assertEquals(vo.getIdx(), 11); // 기대값 : 생성된 시퀀스값
//	}

	
	@DisplayName("insertMain")
	@Test
	void insertMain() {
		Community vo = Community.builder()
				.writer("동동해행")
				.title("자바정석 후기")
				.content("자바 공부하기")
				.build();
		
		int result = communityDao.maxOf();
		communityDao.insert(vo);
		assertEquals(vo.getIdx(), result+1);
	}

	
//	@DisplayName("메인글 목록 : list 크기와 count 로 구한 값이 같아야 한다.")
//	@Test
//	void mainList() {
//		List<Community> list = communityDao.list();
//		int count = communityDao.count();
//		assertEquals(list.size(), count);
//	}
	
	
}


