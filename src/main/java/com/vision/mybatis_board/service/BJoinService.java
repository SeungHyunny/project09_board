package com.vision.mybatis_board.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.vision.mybatis_board.dao.BMDao;


public class BJoinService implements IBoardService {

	private SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		BMDao dao = sqlSession.getMapper(BMDao.class);
		dao.join(id, pw, name, phone);
	
	}

}
