package com.vision.mybatis_board.dao;

import java.util.ArrayList;
import com.vision.mybatis_board.dto.BDto;

public interface BDao {
	public ArrayList<BDto> list(); //목록
	public BDto contentView(int strID);	// 목록에서 선택한 행의 내용을 상세하게 보이기
	public void write(final String bname, final String btitle, final String bcontent); //게시글작성
	public void modify(final int bid, final String bname, final String btitle, final String bcontent); //수정
	public void delete(final int bid); //삭제
	public void reply(final int bid, final String bname, final String btitle, final String bcontent,
			final int broup, final int bstep, final int bindent); //댓글달기
	public BDto reply_view(int strID); //댓글보이기
	public void upHit(final int bid); //조회수 증가시키기

}
