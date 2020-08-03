package com.squiron.service.bs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squiron.service.exception.ConfigurationConflictException;
import com.squiron.service.pojo.ConfigurationScale;
import com.squiron.service.pojo.Event;
import com.squiron.service.pojo.FilterScale;
import com.squiron.service.repository.ConfigurationRepository;

@Service
public class ScaleBS {
	
		
	@Autowired
	private ConfigurationRepository repository;
	
	public long incluirConfiguracao(ConfigurationScale newConfiguration) throws ConfigurationConflictException {
	
		ArrayList<ConfigurationScale> configuracoesEscala = repository.findByGroup(newConfiguration.getGroup());
		//TODO: verificar conflito
		
		//Obter configuracao para mesmo dia da semana, turno
		if (verifyExistenceConfig(newConfiguration,configuracoesEscala)) {
			
			throw new ConfigurationConflictException();
			
		}
		
		repository.save(newConfiguration);
		
		
		return newConfiguration.getId();
	}
	
	public boolean verifyExistenceConfig(ConfigurationScale newConfigurationScale,ArrayList<ConfigurationScale> configuracoesEscala) {
		
		for (ConfigurationScale configurationScale : configuracoesEscala) {
			if (configurationScale.getGroup().equals(newConfigurationScale.getGroup())) {
				if (configurationScale.getShift().equals(newConfigurationScale.getShift())) {
					if (configurationScale.getWeekday().equals(newConfigurationScale.getWeekday())) {
						return true;
					}
				}	
			}
		}		
		return false;
		
	}
	
	public List<Event> getEvents(FilterScale filter){
		
		List<Event> events = new ArrayList<Event>();
		
		ArrayList<ConfigurationScale> configuracoesEscala = repository.findByGroup(filter.getGroup());
		
		for (ConfigurationScale configurationScale : configuracoesEscala) {
			if (configurationScale.getGroup().equals(filter.getGroup())) {
				if (filter.getConfiguration() != null) {
					if(configurationScale.equals(filter.getConfiguration())) {
						events.addAll(getEvents(configurationScale,filter.getBeginDate(), filter.getEndDate()));
					}else {
						continue;
					}
				}else {
					events.addAll(getEvents(configurationScale,filter.getBeginDate(), filter.getEndDate()));
				}	
			}
		}
		return events;
		 
	}
	
	public List<Event> getEvents(ConfigurationScale configuration, Date beginDate, Date endDate){
		
		List<Event> events = new ArrayList<Event>();
		Event e;
		
		Date referenceDay = beginDate;		
        Calendar cal = Calendar.getInstance();        
        cal.setTime(referenceDay);
        
        switch (configuration.getFrequency().getId()) {
        
        //Single Event 
		case 1:
			
			if (checkDate(referenceDay,beginDate,endDate)) {
			
				e = new Event(configuration.getMember(),configuration.getStartDate(),configuration.getShift());
				
				events.add(e);
			}
			
			break;
			
		//Dayly
		case 2:
			
			int i = 0;
			
			while  (checkDate(increseDay(referenceDay,i),beginDate,endDate)) {
				
				e = new Event(configuration.getMember(),increseDay(referenceDay,i),configuration.getShift());
				
				events.add(e);
				
				i++;
			}
			
			break;
			
		//Weekly
		case 3:
			
			int dayOfWeek = configuration.getWeekday().getId();
			
			i = 0;
			
			while  (checkDate(increseDay(referenceDay,i),beginDate,endDate)) {
				
				if (getDayOfWeek(increseDay(referenceDay,i)) == dayOfWeek) {
					
					e = new Event(configuration.getMember(),increseDay(referenceDay,i),configuration.getShift());
					
					events.add(e);
					
					//increse one week
					i= i + 7;
					
					continue;
				}
				
				i++;
			}
			
			break;
			
		//Fortnightly
		case 4:
			
			dayOfWeek = configuration.getWeekday().getId();
			
			i = 0;
			
			referenceDay= increseDay(configuration.getLastEvent(),14);
			
			while  (referenceDay.compareTo(beginDate)<0) {
				
				referenceDay= increseDay(configuration.getLastEvent(),14);
				
			}
			
			while  (checkDate(increseDay(referenceDay,i),beginDate,endDate)) {
				
				if (getDayOfWeek(increseDay(referenceDay,i)) == dayOfWeek) {
					
					e = new Event(configuration.getMember(),increseDay(referenceDay,i),configuration.getShift());
					
					events.add(e);
					
					//increse one week
					i= i + 14;
					
					continue;
				}
				
				i++;
			}
			
			break;
		//monthly
		case 5:
			
			dayOfWeek = configuration.getWeekday().getId();
			
			i = 0;
			
			referenceDay= increseDay(configuration.getLastEvent(),28);
			
			while  (checkDate(increseDay(referenceDay,i),beginDate,endDate)) {
				
				if (getDayOfWeek(increseDay(referenceDay,i)) == dayOfWeek) {
					
					e = new Event(configuration.getMember(),increseDay(referenceDay,i),configuration.getShift());
					
					events.add(e);
					
					//increse one month
					i= i + 28;
					
					continue;
				}
				
				i++;
			}
			
			break;
		} 
        
        
        return events;
		
	}

	public int getDayOfWeek(Date date) {
				
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	private Date increseDay(Date referenceDay, int i) {
		
		Calendar c = Calendar.getInstance();		
		c.setTime(referenceDay); 
		c.add(Calendar.DATE, i);		
		return c.getTime();
		
	}

	public boolean checkDate(Date referDate, Date beginDate, Date endDate) {
		if (!referDate.after(endDate) && !referDate.before(beginDate)) {
			return true;
		}
		return false;
	}

}
