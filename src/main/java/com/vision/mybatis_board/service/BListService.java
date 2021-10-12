package com.vision.mybatis_board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.vision.mybatis_board.dao.BDao;
import com.vision.mybatis_board.dto.BDto;

import java.util.Collections;

// 페이징 처리 부분도 포함시키는 것이 바람직함 
public class BListService implements IBoardService{

	private SqlSession sqlSession = Constant.sqlSession;
	public static final int MESSAGE_COUNT_PER_PAGE = 10;
	public BListService() {}
	@Override
	public void execute(Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list",dtos);
	}
	// 추가 메소드 들 
	public List<BDto> selectList(int a,int z) throws SQLException{
		BDao dao = sqlSession.getMapper(BDao.class);
		ArrayList<BDto> dtos = dao.list();//모든 자료 
		return dtos.subList(a-1,z);// 페이지에 나타낼 자료
	}
	
	// 페이징 처리를 위한 객체 얻기
	public MessageListView getMessageListView(int pageNumber) throws SQLException{
		int currentPageNumber = pageNumber;
		BDao dao = sqlSession.getMapper(BDao.class);
		int messageTotalCount = dao.list().size(); 
		List<BDto> messageList = null;
		int firstRow = 0;
		int endRow = 0;
		if(messageTotalCount>0) {
			// 10페이지 같으면 (10-1)*MESSAGE_COUNT_PER_PAGE +1  ===> 10페이지 첫행은 91번 자료 
			firstRow = (pageNumber-1) * MESSAGE_COUNT_PER_PAGE+1;
			endRow = firstRow + MESSAGE_COUNT_PER_PAGE -1; //100 
			// 마지막 페이지의 끝번호는 고려할 것이 있다. 마지막 자료보다 큰 인덱스 이면 안된다.
			if(endRow>messageTotalCount) {
				endRow = messageTotalCount;
			}
			messageList = selectList(firstRow,endRow);
			
		}else {
			currentPageNumber = 0;
			messageList = Collections.emptyList();
			
		}
		return new MessageListView(
				messageTotalCount,currentPageNumber,messageList,MESSAGE_COUNT_PER_PAGE,firstRow,endRow
		);
	}

}
