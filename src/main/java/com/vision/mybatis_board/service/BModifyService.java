package com.vision.mybatis_board.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.vision.mybatis_board.dao.BDao;

public class BModifyService implements IBoardService{
	private SqlSession sqlSession = Constant.sqlSession;
	@Override
	public void execute(Model model) {
		// TODO 상세보기에서 수정 버튼을 눌렀을 때 해야하는 작업
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = 
				(HttpServletRequest)map.get("request");
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.modify(bid, bname, btitle, bcontent);
		
	}
}
