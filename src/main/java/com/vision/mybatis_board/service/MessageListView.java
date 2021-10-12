package com.vision.mybatis_board.service;

import java.util.List;

import com.vision.mybatis_board.dto.BDto;

// 게시목록의 페이징 처리를 위해 사용할 클래스 
public class MessageListView {
	
	private int messageTotalCount; // 총자료수 
	private int currentPageNumber; // 현재페이지 
	private List<BDto> messageList;// 모든자료
	private int messageCountPerPage; // 한 페이지에 나타낼 자료수 
	private int firstRow; // 어떤 페이지에 나타낼 첫행
	private int endRow; // 어떤 페이지에 나타낼 마지막 행 
	
	private int pageTotalCount;// 총페이지수  모든자료를 페이지에 나타낼 자료수로 나눈값

	public MessageListView(int messageTotalCount, int currentPageNumber, List<BDto> messageList, 
			int messageCountPerPage, int firstRow, int endRow) {
		super();
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calculatePageTotalCount();
	}
	
	private void calculatePageTotalCount() {
		if(messageTotalCount == 0) {
			pageTotalCount = 0;
		}else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			if(messageTotalCount % messageCountPerPage > 0 ) {
				pageTotalCount++;
			}
		}
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<BDto> getMessageList() {
		return messageList;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}
	
	public boolean isEmpty() {
		return messageTotalCount==0;
	}

}
