package com.hit.beans;

import java.io.Serializable;

public class NoticeBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int noticeId;
	
	public String noticeTitle;
	
	public String noticeInfo;

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeInfo() {
		return noticeInfo;
	}

	public void setNoticeInfo(String noticeInfo) {
		this.noticeInfo = noticeInfo;
	}

	public NoticeBean(int noticeId, String noticeTitle, String noticeInfo) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeInfo = noticeInfo;
	}

	public NoticeBean() {
		super();
	}
	
	
	
}
