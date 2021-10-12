package com.vision.mybatis_board.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.vision.mybatis_board.dao.BDao;

public class BReplyService implements IBoardService{
	private SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		//TODO 댓글폼에서 전달받은 정보를 데이타베이스에 등록 
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		// 댓글을 등록하려면 본글의 id를 알아야 함
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		// 댓글은 추가 정보가 필요 
		int bgroup = Integer.parseInt(request.getParameter("bgroup"));
		int bstep = Integer.parseInt(request.getParameter("bstep"));
		int bindent = Integer.parseInt(request.getParameter("bindent"));
				
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.reply(bid,bname, btitle, bcontent,bgroup,bstep,bindent);
	
	}

}
