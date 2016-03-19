package com.adchallenge.model;

import java.util.Date;

/**
 * This class is responsible for the each website URL data.
 * 
 * @author hvanparx
 * 
 */
public class Website {

	int count;
	String websiteUrl;
	Date lastClickedTime;

	public Website(String string) {
		this.websiteUrl = string;
	}
	public Website(){
		
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public Date getLastClickedTime() {
		return lastClickedTime;
	}

	public void setLastClickedTime(Date lastClickedTime) {
		this.lastClickedTime = lastClickedTime;
	}
	
	@Override
	public int hashCode() {
		return this.getWebsiteUrl().hashCode();
	}
	@Override
	public boolean equals(Object arg0) {
		Website web0 = (Website)arg0;
		return web0.getWebsiteUrl().equals(this.getWebsiteUrl());
		
//		return super.equals(arg0);
	}

}
