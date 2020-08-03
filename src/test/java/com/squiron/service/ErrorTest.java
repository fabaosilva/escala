package com.squiron.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import javax.xml.ws.Response;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squiron.service.domain.WeekDay;
import com.squiron.service.exception.ApiError;
import com.squiron.service.pojo.ConfigurationScale;
import com.squiron.service.pojo.Frequency;
import com.squiron.service.pojo.Group;
import com.squiron.service.pojo.Member;
import com.squiron.service.pojo.Shift;
import com.squiron.service.rest.ScaleController;

@SpringBootTest
@AutoConfigureMockMvc
public class ErrorTest {
	
	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ScaleController service;

	private static final String URL_PREFIX = "http://localhost:8090/api/";

	@Test
	public void whenConflitConfigurationW_thenConflitErro() {
		
		ConfigurationScale conf1L = new ConfigurationScale();
		Group group1L = new Group();
		group1L.setId(1L);
		conf1L.setGroup(group1L);
		
		conf1L.setFrequency(Frequency.SEMANAL);
		conf1L.setCreatedDate(new Date());
		Member member = new Member();
		member.setId(1L);
		conf1L.setMember(member );
		Shift shift = new Shift();
		shift.setId(1L);
		conf1L.setShift(shift);
		conf1L.setStartDate(new Date());
		conf1L.setWeekday(WeekDay.QUARTA);
		
		try {
			mockMvc.perform(
					post("http://localhost:8090/api/configuration").contentType("application/json").content(objectMapper.writeValueAsString(conf1L)));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		group1L.setId(1L);
		conf1L.setGroup(group1L);
		
		conf1L.setFrequency(Frequency.SEMANAL);
		conf1L.setCreatedDate(new Date());
		member = new Member();
		member.setId(1L);
		conf1L.setMember(member );
		shift = new Shift();
		shift.setId(1L);
		conf1L.setShift(shift);
		conf1L.setStartDate(new Date());
		conf1L.setWeekday(WeekDay.QUARTA);
		
		try {
			mockMvc.perform(
					post("http://localhost:8090/api/configuration").contentType("application/json").content(objectMapper.writeValueAsString(conf1L)))
					.andExpect(status().is4xxClientError());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void whenConflitConfigurationD_thenConflitErro() {
		
		ConfigurationScale conf1L = new ConfigurationScale();
		Group group1L = new Group();
		group1L.setId(1L);
		conf1L.setGroup(group1L);
		
		conf1L.setFrequency(Frequency.DIARIA);
		conf1L.setCreatedDate(new Date());
		Member member = new Member();
		member.setId(1L);
		conf1L.setMember(member );
		Shift shift = new Shift();
		shift.setId(1L);
		conf1L.setShift(shift);
		conf1L.setStartDate(new Date());
		conf1L.setWeekday(WeekDay.QUARTA);
		
		try {
			mockMvc.perform(
					post("http://localhost:8090/api/configuration").contentType("application/json").content(objectMapper.writeValueAsString(conf1L)));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		group1L.setId(1L);
		conf1L.setGroup(group1L);
		
		conf1L.setFrequency(Frequency.SEMANAL);
		conf1L.setCreatedDate(new Date());
		member = new Member();
		member.setId(1L);
		conf1L.setMember(member );
		shift = new Shift();
		shift.setId(1L);
		conf1L.setShift(shift);
		conf1L.setStartDate(new Date());
		conf1L.setWeekday(WeekDay.QUARTA);
		
		try {
			mockMvc.perform(
					post("http://localhost:8090/api/configuration").contentType("application/json").content(objectMapper.writeValueAsString(conf1L)))
					.andExpect(status().is4xxClientError());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void whenConflitConfigurationM_thenConflitErro() {
		
		ConfigurationScale conf1L = new ConfigurationScale();
		Group group1L = new Group();
		group1L.setId(1L);
		conf1L.setGroup(group1L);
		
		conf1L.setFrequency(Frequency.MENSAL);
		conf1L.setCreatedDate(new Date());
		Member member = new Member();
		member.setId(1L);
		conf1L.setMember(member );
		Shift shift = new Shift();
		shift.setId(1L);
		conf1L.setShift(shift);
		conf1L.setStartDate(new Date());
		conf1L.setWeekday(WeekDay.QUARTA);
		
		try {
			mockMvc.perform(
					post("http://localhost:8090/api/configuration").contentType("application/json").content(objectMapper.writeValueAsString(conf1L)));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		group1L.setId(1L);
		conf1L.setGroup(group1L);
		
		conf1L.setFrequency(Frequency.SEMANAL);
		conf1L.setCreatedDate(new Date());
		member = new Member();
		member.setId(1L);
		conf1L.setMember(member );
		shift = new Shift();
		shift.setId(1L);
		conf1L.setShift(shift);
		conf1L.setStartDate(new Date());
		conf1L.setWeekday(WeekDay.QUARTA);
		
		try {
			mockMvc.perform(
					post("http://localhost:8090/api/configuration").contentType("application/json").content(objectMapper.writeValueAsString(conf1L)))
					.andExpect(status().is4xxClientError());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
