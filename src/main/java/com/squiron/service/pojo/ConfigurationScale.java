package com.squiron.service.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.squiron.service.domain.WeekDay;

@Entity
public class ConfigurationScale {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="group_id", referencedColumnName="id")
	private Group group;
	
	@ManyToOne
	@JoinColumn(name="member_id", referencedColumnName="id")
	private Member member;
	
	private WeekDay weekday;
	
	@ManyToOne
	@JoinColumn(name="shift_id", referencedColumnName="id")
	private Shift shift;
	
	private Frequency frequency;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastEvent;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public WeekDay getWeekday() {
		return weekday;
	}
	public void setWeekday(WeekDay weekday) {
		this.weekday = weekday;
	}
	public Shift getShift() {
		return shift;
	}
	public void setShift(Shift shift) {
		this.shift = shift;
	}
	public Frequency getFrequency() {
		return frequency;
	}
	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	public Date getLastEvent() {
		return lastEvent;
	}
	public void setLastEvent(Date lastEvent) {
		this.lastEvent = lastEvent;
	}
	
	

	
	
	
}
