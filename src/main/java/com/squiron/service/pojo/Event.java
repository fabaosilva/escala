package com.squiron.service.pojo;

import java.util.Date;

public class Event {
	
	private Member member;
	private Date date;
	private Shift shift;
	
	
	
	public Event(Member member, Date date, Shift shift) {
		super();
		this.member = member;
		this.date = date;
		this.shift = shift;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Shift getShift() {
		return shift;
	}
	public void setShift(Shift shift) {
		this.shift = shift;
	}
	
	
	

}
