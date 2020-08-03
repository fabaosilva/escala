package com.squiron.service;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.squiron.service.bs.ScaleBS;
import com.squiron.service.domain.WeekDay;
import com.squiron.service.pojo.ConfigurationScale;
import com.squiron.service.pojo.Event;
import com.squiron.service.pojo.Frequency;
import com.squiron.service.pojo.Member;
import com.squiron.service.pojo.Shift;

@SpringBootTest
public class EventsTests {
	
	@Test
	public void dalyEventToMonthAgust() {
		
		ScaleBS scaleBS = new ScaleBS();
		
		ConfigurationScale configuration = new ConfigurationScale();
		
		Calendar beginDate = Calendar.getInstance();
		
		Calendar endDate = Calendar.getInstance();
		
		beginDate.set(2020,6,6);
		
		endDate.set(2020,6,10);
		
		configuration.setStartDate(new Date());
		
		configuration.setFrequency(Frequency.DIARIA);
		
		Member member =  new Member();
		
		member.setId(1L);
		
		Shift shift = new Shift();
		
		shift.setId(1L);
		
		configuration.setShift(shift);
		
		configuration.setMember(member);
		
		List<Event> events = scaleBS.getEvents(configuration, beginDate.getTime(), endDate.getTime());
		
		assertEquals(events.size(), 5);
		
		for (Event event : events) {
			
			assertEquals(scaleBS.checkDate(event.getDate(), beginDate.getTime(), endDate.getTime()),true);
			
			assertEquals(event.getMember().equals(member),true);
			
			assertEquals(event.getShift().equals(shift),true);
			
			System.out.println("Day:" + event.getDate());
						
		}
		
	}
	
	@Test
	public void weeklyEventToMonthAgust() {
		
		ScaleBS scaleBS = new ScaleBS();
		
		ConfigurationScale configuration = new ConfigurationScale();
		
		Calendar lastEvent = Calendar.getInstance();
		
		Calendar beginDate = Calendar.getInstance();
		
		Calendar endDate = Calendar.getInstance();
		
		lastEvent.set(2020,5,25);
		
		beginDate.set(2020,6,1);
		
		endDate.set(2020,6,31);
		
		configuration.setLastEvent(lastEvent.getTime());
		
		configuration.setStartDate(new Date());
		
		configuration.setFrequency(Frequency.SEMANAL);
				
		configuration.setWeekday(WeekDay.QUINTA);
		
		Member member =  new Member();
		
		member.setId(1L);
		
		Shift shift = new Shift();
		
		shift.setId(1L);
		
		configuration.setShift(shift);
		
		configuration.setMember(member);
		
		List<Event> events = scaleBS.getEvents(configuration, beginDate.getTime(), endDate.getTime());
		
		assertEquals(events.size(), 5);
		
		for (Event event : events) {
			
			assertEquals(scaleBS.checkDate(event.getDate(), beginDate.getTime(), endDate.getTime()),true);
			
			assertEquals(event.getMember().equals(member),true);
			
			assertEquals(event.getShift().equals(shift),true);
			
			assertEquals(scaleBS.getDayOfWeek(event.getDate()) == WeekDay.QUINTA.getId() ,true);
			
			System.out.println("Day:" + event.getDate());
						
		}
		
	}
	
	@Test
	public void fortnightlyEventToMonthAgustThursday() {
		
		ScaleBS scaleBS = new ScaleBS();
		
		ConfigurationScale configuration = new ConfigurationScale();
		
		Calendar beginDate = Calendar.getInstance();
		
		Calendar endDate = Calendar.getInstance();
		
		Calendar lastEvent = Calendar.getInstance();
		
		lastEvent.set(2020,5,18);
		
		beginDate.set(2020,6,1);
		
		endDate.set(2020,6,31);
		
		configuration.setLastEvent(lastEvent.getTime());
		
		configuration.setStartDate(new Date());
		
		configuration.setFrequency(Frequency.QUINZENAL);
				
		configuration.setWeekday(WeekDay.QUINTA);
		
		Member member =  new Member();
		
		member.setId(1L);
		
		Shift shift = new Shift();
		
		shift.setId(1L);
		
		configuration.setShift(shift);
		
		configuration.setMember(member);
		
		List<Event> events = scaleBS.getEvents(configuration, beginDate.getTime(), endDate.getTime());
		
		assertEquals(events.size(), 3);
		
		for (Event event : events) {
			
			assertEquals(scaleBS.checkDate(event.getDate(), beginDate.getTime(), endDate.getTime()),true);
			
			assertEquals(event.getMember().equals(member),true);
			
			assertEquals(event.getShift().equals(shift),true);
			
			assertEquals(scaleBS.getDayOfWeek(event.getDate()) == WeekDay.QUINTA.getId() ,true);
			
			System.out.println("Day:" + event.getDate());
						
		}
		
	}
	
	@Test
	public void monthtlyEventToMonthAgustThursday() {
		
		ScaleBS scaleBS = new ScaleBS();
		
		ConfigurationScale configuration = new ConfigurationScale();
		
		Calendar beginDate = Calendar.getInstance();
		
		Calendar endDate = Calendar.getInstance();
		
		Calendar lastEvent = Calendar.getInstance();
		
		lastEvent.set(2020,5,4);
		
		beginDate.set(2020,6,1);
		
		endDate.set(2020,6,31);
		
		configuration.setLastEvent(lastEvent.getTime());
		
		configuration.setStartDate(new Date());
		
		configuration.setFrequency(Frequency.MENSAL);
				
		configuration.setWeekday(WeekDay.QUINTA);
		
		Member member =  new Member();
		
		member.setId(1L);
		
		Shift shift = new Shift();
		
		shift.setId(1L);
		
		configuration.setShift(shift);
		
		configuration.setMember(member);
		
		List<Event> events = scaleBS.getEvents(configuration, beginDate.getTime(), endDate.getTime());
		
		assertEquals(events.size(), 1);
		
		for (Event event : events) {
			
			assertEquals(scaleBS.checkDate(event.getDate(), beginDate.getTime(), endDate.getTime()),true);
			
			assertEquals(event.getMember().equals(member),true);
			
			assertEquals(event.getShift().equals(shift),true);
			
			assertEquals(scaleBS.getDayOfWeek(event.getDate()) == WeekDay.QUINTA.getId() ,true);
			
			System.out.println("Day:" + event.getDate());
						
		}
		
	}
	
	
	
}
