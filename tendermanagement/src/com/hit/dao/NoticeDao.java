package com.hit.dao;

public interface NoticeDao {
		
	public String removeNotice(String noticeId);
	
	public String addNotice(String noticeId, String noticeTitle, String noticeDesc );
	
}
