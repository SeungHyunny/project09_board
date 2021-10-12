package com.vision.mybatis_board.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.vision.mybatis_board.dao.BDao;
import com.vision.mybatis_board.dto.BDto;

public class BReplyViewService implements IBoardService{
	private SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		//TODO 게시판폼에서 전달받은 정보를 데이타베이스에 등록 
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int bid = Integer.parseInt(request.getParameter("bid"));
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.upHit(bid);
		BDto dto = dao.reply_view(bid);
		model.addAttribute("reply_view", dto);
	}

}
