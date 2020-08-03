package com.squiron.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squiron.service.pojo.Group;
import com.squiron.service.rest.ScaleController;

@SpringBootTest
@AutoConfigureMockMvc
public class CrudGroupTest {

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
			Group group = new Group("HC");
			mockMvc.perform(MockMvcRequestBuilders.post(URL_PREFIX + "groups").contentType("application/json")
					.content(objectMapper.writeValueAsString(group))).andExpect(status().is2xxSuccessful());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
