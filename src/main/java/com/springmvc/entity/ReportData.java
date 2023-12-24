package com.springmvc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="report_details")
public class ReportData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	String fromdate ;
	String todate;
	@Override
	public String toString() {
		return "Report [fromdate=" + fromdate + ", todate=" + todate + "]";
	}
	
	
	
}
