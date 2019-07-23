package com.hit.dao;

import java.util.List;

import com.hit.beans.TenderBean;

public interface TenderDao {
	
	public List<TenderBean> getTenderDetails(String id);
	
	public List<TenderBean> getAllTenders();
	
	public String createTender(TenderBean tender);
	
	public boolean removeTender(String tid);
	
	public String updateTender(TenderBean tender);
	
	
}
