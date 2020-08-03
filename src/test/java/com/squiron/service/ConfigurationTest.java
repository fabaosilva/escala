package com.squiron.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squiron.service.domain.WeekDay;
import com.squiron.service.pojo.ConfigurationScale;
import com.squiron.service.pojo.Frequency;
import com.squiron.service.pojo.Group;
import com.squiron.service.pojo.Member;
import com.squiron.service.pojo.Shift;
import com.squiron.service.rest.ScaleController;

@SpringBootTest
@AutoConfigureMockMvc
public class ConfigurationTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ScaleController service;

	private static final String URL_PREFIX = "http://localhost:8090/";

	@Test
	public void post() {
		try {
			
			
			//Criando o grupo
			
			Group group = new Group("HC");
			
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post(URL_PREFIX + "groups").contentType("application/json")
					.content(objectMapper.writeValueAsString(group)));
						
			String urlGroup = result.andReturn().getResponse().getHeader("location").toString();
			
			result = mockMvc.perform(MockMvcRequestBuilders.get(urlGroup).contentType("application/json"));
			
			JsonNode jn =  objectMapper.readTree(result.andReturn().getResponse().getContentAsString());
			
			List<JsonNode> urls = jn.findValues("members");
			
			jn = urls.get(0);
			
			String urlAssoiacaoMembers = jn.findValues("href").toString();
			
			urlAssoiacaoMembers = urlAssoiacaoMembers.replace("[\"", "");
			
			urlAssoiacaoMembers = urlAssoiacaoMembers.replace("\"]", "");
			
			jn =  objectMapper.readTree(result.andReturn().getResponse().getContentAsString());
			
			urls = jn.findValues("shifts");
			
			jn = urls.get(0);
			
			String urlAssoiacaoShifits = jn.findValues("href").toString();
			
			urlAssoiacaoShifits = urlAssoiacaoShifits.replace("[\"", "");
			
			urlAssoiacaoShifits = urlAssoiacaoShifits.replace("\"]", "");
			
			//Criando um membro
			
			Member member1 = new Member();
			member1.setName("Fabio");
			member1.setFone(10);
			
			result = mockMvc.perform(MockMvcRequestBuilders.post(URL_PREFIX + "members").contentType("application/json")
					.content(objectMapper.writeValueAsString(member1)));
			
			String urlMember = result.andReturn().getResponse().getHeader("location").toString();
			
			
			//Associando o membro ao grupo
			
			result = mockMvc.perform(MockMvcRequestBuilders.put(urlAssoiacaoMembers).contentType("text/uri-list")
					.content(urlMember));
			
			
			//Criando um turno1
						
			Shift shift1 = new Shift("Manhã");
			
			result = mockMvc.perform(MockMvcRequestBuilders.post(URL_PREFIX + "shifts").contentType("application/json")
					.content(objectMapper.writeValueAsString(shift1)));
			
			String urlShift = result.andReturn().getResponse().getHeader("location").toString();
			
			//Criando um turno2
			
			Shift shift2 = new Shift("Tarde");
			
			result = mockMvc.perform(MockMvcRequestBuilders.post(URL_PREFIX + "shifts").contentType("application/json")
					.content(objectMapper.writeValueAsString(shift2)));
			
			String urlShift2 = result.andReturn().getResponse().getHeader("location").toString();
			
			
			//Associando o turno1 ao grupo
			
			result = mockMvc.perform(MockMvcRequestBuilders.put(urlAssoiacaoShifits).contentType("text/uri-list")
					.content(urlShift));
			
			//Associando o turno2 ao grupo
			
			result = mockMvc.perform(MockMvcRequestBuilders.put(urlAssoiacaoShifits).contentType("text/uri-list")
					.content(urlShift2));
			
			//Pegando as url de associações
			
			String[] urlSplit = urlGroup.split("/");
			
			Long id = new Long(urlSplit[urlSplit.length-1]);
			
			group.setId(id);
			
			//Seta id do membro
			
			urlSplit = urlMember.split("/");
			
			id = new Long(urlSplit[urlSplit.length-1]);
			
			member1.setId(id);
			
			//Seta id do shift
			
			urlSplit = urlShift.split("/");
			
			id = new Long(urlSplit[urlSplit.length-1]);
			
			shift1.setId(id);
			
			//Seta id do shift2
			
			urlSplit = urlShift2.split("/");
			
			id = new Long(urlSplit[urlSplit.length-1]);
			
			shift2.setId(id);
			
			//Criando uma configuração membro 1, Semanal, segunda, turno1
			
			ConfigurationScale conf1 = new ConfigurationScale();
			
			conf1.setGroup(group);
			conf1.setFrequency(Frequency.SEMANAL);
			conf1.setCreatedDate(new Date());
			conf1.setLastEvent(new Date());
			conf1.setMember(member1);
			conf1.setShift(shift1);
			conf1.setWeekday(WeekDay.SEGUNDA);
			conf1.setStartDate(new Date());
			
			result =  mockMvc.perform(MockMvcRequestBuilders.post(URL_PREFIX + "/api/configurations").contentType("application/json")
					.content(objectMapper.writeValueAsString(conf1)));
			
			//Criando uma configuração membro 1, Semanal, quarta, turno1
			
			conf1 = new ConfigurationScale();
			
			conf1.setGroup(group);
			conf1.setFrequency(Frequency.SEMANAL);
			conf1.setCreatedDate(new Date());
			conf1.setLastEvent(new Date());
			conf1.setMember(member1);
			conf1.setShift(shift1);
			conf1.setWeekday(WeekDay.QUARTA);
			conf1.setStartDate(new Date());
			
			result =  mockMvc.perform(MockMvcRequestBuilders.post(URL_PREFIX + "/api/configurations").contentType("application/json")
					.content(objectMapper.writeValueAsString(conf1)));
			
			//Criando uma configuração membro 1, Semanal, sexta, turno1
			
			conf1 = new ConfigurationScale();
			
			conf1.setGroup(group);
			conf1.setFrequency(Frequency.SEMANAL);
			conf1.setCreatedDate(new Date());
			conf1.setLastEvent(new Date());
			conf1.setMember(member1);
			conf1.setShift(shift1);
			conf1.setWeekday(WeekDay.SEXTA);
			conf1.setStartDate(new Date());
			
			result =  mockMvc.perform(MockMvcRequestBuilders.post(URL_PREFIX + "/api/configurations").contentType("application/json")
					.content(objectMapper.writeValueAsString(conf1)));
			
			//Criando uma configuração membro 1, Semanal, sexta, turno1
			
			conf1 = new ConfigurationScale();
			
			conf1.setGroup(group);
			conf1.setFrequency(Frequency.SEMANAL);
			conf1.setCreatedDate(new Date());
			conf1.setLastEvent(new Date());
			conf1.setMember(member1);
			conf1.setShift(shift1);
			conf1.setWeekday(WeekDay.SEXTA);
			conf1.setStartDate(new Date());
			
			result =  mockMvc.perform(MockMvcRequestBuilders.post(URL_PREFIX + "/api/configurations").contentType("application/json")
					.content(objectMapper.writeValueAsString(conf1)));
			
			result.andReturn().getResponse().getHeader("status");
			
			//
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
