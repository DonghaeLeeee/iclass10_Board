package community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

import controller.Controller;
//글쓰기 저장 POST
public class WriteController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	//POST에서 필수
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		//클라이언트의 IP주소
		
		Community vo =  Community.builder()
				.title(title)
				.writer(writer)
				.content(content)
				.ip(ip)
				.build();
		
		CommunityDao dao = CommunityDao.getInstance();
		long result = dao.insert(vo);
		if(result != 0) {
			response.sendRedirect("list");
		}else {
			//메인화면으로 이동
			response.sendRedirect(request.getContextPath());
		}
		
	}

}