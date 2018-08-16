package com.yc.bean;

import java.io.Serializable;

public class OpRecord implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer accountid;
	private Double opmoney;
	private String optime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	public Double getOpmoney() {
		return opmoney;
	}
	public void setOpmoney(Double opmoney) {
		this.opmoney = opmoney;
	}
	public String getOptime() {
		return optime;
	}
	public void setOptime(String optime) {
		this.optime = optime;
	}

	
}
