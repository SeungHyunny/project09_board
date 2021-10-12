package com.vision.mybatis_board.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.vision.mybatis_board.dao.BDao;
import com.vision.mybatis_board.dto.BDto;

public class BContentService implements IBoardService{
	private SqlSession sqlSession = Constant.sqlSession;
	@Override
	public void execute(Model model) {
		// TODO 목록의 제목을 클릭했을 때 보여줄 상세내용을 위한 서비스 
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int bid = Integer.parseInt(request.getParameter("bId"));
		
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.upHit(bid);
		BDto dto = dao.contentView(bid);
		model.addAttribute("content_view",dto);
	}
}
