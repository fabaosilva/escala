package com.squiron.service.pojo;

import java.util.Date;

public class FilterScale {
	private Group group;
	private Date beginDate;
	private Date endDate;
	private int year;
	private int month;
	private int week;
	private int day;
	private ConfigurationScale configuration;
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public ConfigurationScale getConfiguration() {
		return configuration;
	}
	public void setConfiguration(ConfigurationScale configuration) {
		this.configuration = configuration;
	}
	
	
}
