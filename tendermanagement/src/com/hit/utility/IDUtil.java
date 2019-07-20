package com.hit.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDUtil {
	public static String generateTenderId(){
		String tid = null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		tid=sdf.format(new Date());
		tid = "T"+tid;
		return tid;
	}
	
	
	public static String generateVendorId(){
		String vid = null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		vid=sdf.format(new Date());
		vid = "V"+vid;
		return vid;
	}
	
	public static String generateApplicationId(){
		String appId = null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		appId=sdf.format(new Date());
		appId = "A"+appId;
		return appId;
	}
}
