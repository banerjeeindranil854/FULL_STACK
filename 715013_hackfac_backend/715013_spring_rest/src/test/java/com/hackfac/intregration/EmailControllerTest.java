package com.hackfac.intregration;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackfse.fdbck.mgmt.systm.Application;
import com.hackfse.fdbck.mgmt.systm.RepositoryConfig;
import com.hackfse.fdbck.mgmt.systm.SecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, RepositoryConfig.class, SecurityConfig.class })
@WebAppConfiguration
@ActiveProfiles("test")
public class EmailControllerTest {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getAuthToken() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/sendMail").headers(newHeaders())
				.param("status", "N")
				.param("empId", "715013")
				).andDo(print()).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public HttpHeaders newHeaders() {
		HttpHeaders HttpHeaders = new HttpHeaders();
		HttpHeaders.set("Content-Type", "application/json");
		HttpHeaders.set("Accept", "application/json");
		HttpHeaders.set("Authorization", "BearereyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI3MTUwMTMiLCJBVVRIT1JJVElFU19LRVkiOiJST0xFX0FETUlOUyIsImlhdCI6MTU1MzQ2NjMxOSwiZXhwIjoxNTU0MDcxMTE5fQ._Cl-V5-1ssdLSZ0S834fXxwxUnwVwKPycK_1GhJ9bb-1v7Joplra7LbeGKeG6R39WOIyaD3sm-Kq23WcDFpMmQ");
		return HttpHeaders;

	}
}
