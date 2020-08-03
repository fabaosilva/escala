package com.squiron.service.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.squiron.service.bs.ScaleBS;
import com.squiron.service.exception.ConfigurationConflictException;
import com.squiron.service.pojo.ConfigurationScale;
import com.squiron.service.pojo.Event;
import com.squiron.service.pojo.FilterScale;
import com.squiron.service.pojo.Group;
import com.squiron.service.util.*;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
@RequestMapping("/api")
public class ScaleController {

	@Autowired
	private ScaleBS scaleBS;
	
    @ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
	@PostMapping("/configurations")
    public long addConfiguration(@RequestBody ConfigurationScale resource) {
        //Preconditions.checkNotNull(resource);
						
        return scaleBS.incluirConfiguracao(resource);
    }

	@CrossOrigin
	@GetMapping("/events")
	public List<Event> getEvents(@RequestParam(value = "group") long idGroup,
			@RequestParam(value = "beginDay") String strBeginDay,
			@RequestParam(value = "endDay") String strEndDay,
			@RequestParam(value = "year",defaultValue = "0") int year,
			@RequestParam(value = "month",defaultValue = "0") int month,
			@RequestParam(value = "week",defaultValue = "0") int week,
			@RequestParam(value = "day",defaultValue = "0") int day,
			@RequestParam(value = "configuration",defaultValue = "0") long idConfiguration){
		
		FilterScale filter = new FilterScale();
		
		Date beginDay = DateConvert.covertFromStr(strBeginDay, null); 
		
		Date endDay = DateConvert.covertFromStr(strEndDay, null); 
		
		Group group =  new Group();
		
		group.setId(idGroup);
		
		filter.setGroup(group);
		
		filter.setBeginDate(beginDay);
		
		filter.setEndDate(endDay);
		
		if (idConfiguration!=0) {
			ConfigurationScale configuration = new ConfigurationScale();
			configuration.setId(idConfiguration);
			filter.setConfiguration(configuration);
		}
		
		filter.setDay(day);
		filter.setMonth(month);
		filter.setWeek(week);
		
		
		return scaleBS.getEvents(filter);
	}

}
