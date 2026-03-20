package com.example.recruit.util;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageHandler {
	private int totalCount; // 총 게시물 갯수
	private int pageSize; // 한 페이지의 크기
	private int naviSize = 5; // 페이지 내비게이션의 크기
	private int totalPage; // 전체 페이지 갯수
	private int page; // 현재 페이지
	private int beginPage; // 내비게이션의 첫번째 페이지
	private int endPage; // 내비게이션의 마지막 페이지
	private boolean showPrev; // 이전 페이지로 이동하는 링크를 보여줄 것인지 여부
	private boolean showNext; // 다음 페이지로 이동하는 링크를 보여줄 것인지 여부

	public PageHandler(int totalCount, int page, int pageSize) {
		this.totalCount = totalCount;
		this.page = page;
		this.pageSize = pageSize;

		this.totalPage = (int) Math.ceil(totalCount / (double) pageSize);
		this.beginPage = (page - 1) / naviSize * naviSize + 1;
		this.endPage = Math.min(beginPage + naviSize - 1, totalPage);
		this.showPrev = beginPage != 1;
		this.showNext = endPage != totalPage;
	}
}
