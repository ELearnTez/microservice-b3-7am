package com.yuvintech.spring.boot.mobile.integration;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yuvintech.msk.common.dto.MobileDto;
import com.yuvintech.msk.common.dto.Response;
import com.yuvintech.msk.common.dto.SaveMobileDto;



@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MobileServiceIntegrationTest {

		
	
	@Autowired
	private MockMvc mvc;
	
	@WithMockUser(username = "mobile-service-user", password = "mobile-service-user", roles = "MOBILE_USER")
	@Test
	@Order(1)
	public void testGetMobileDtoById() throws Exception {
		mvc.perform(
				  get("/mobiles/1")
				  .accept(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().is(200))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.response.id").value(1))
		.andExpect(jsonPath("$.response.name").value("Samsung"))
		.andExpect(jsonPath("$.response.price").value("10000.0"));	
	}
	
	@WithMockUser(username = "mobile-service-user", password = "mobile-service-user", roles = "MOBILE_USER")
	@Test
	@Order(2)
	public void testGetMobileDtoByIdInvalid() throws Exception {
		mvc.perform(
				  get("/mobiles/100")
				  .accept(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().is(400))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errors[0].code").value(1011))
		.andExpect(jsonPath("$.errors[0].message").value("Mobile Not Found with given MObile Id"));	
	}
	
	@WithMockUser(username = "mobile-service-user", password = "mobile-service-user", roles = "MOBILE_USER")
	@Test
	@Order(3)
	public void testGetMobileDtoById2() throws Exception {
		mvc.perform(
				  get("/mobiles/2")
				  .accept(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().is(200))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.response.id").value(2))
		.andExpect(jsonPath("$.response.name").value("Samsung"))
		.andExpect(jsonPath("$.response.price").value("10000.0"))
		.andExpect(jsonPath("$.response.status").value("AVAILABLE"))
		.andExpect(jsonPath("$.response.lineOfBusiness").value("RETAIL"))
		.andExpect(jsonPath("$.response.countryCode").value("KOR"))
		.andExpect(jsonPath("$.response.publicationDate").value("2020-07-22"))
		.andExpect(jsonPath("$.response.accessoryType").value("ALL"))
		;
	}
	
	@WithMockUser(username = "mobile-service-user", password = "mobile-service-user", roles = "MOBILE_USER")
	@Test
	@Order(4)
	public void testGetAllMobiles() throws Exception {
		mvc.perform(
				  get("/mobiles")
				  .accept(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().is(200))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.response", hasSize(20)))
		.andExpect(jsonPath("$.response[4].id").value(5))
		.andExpect(jsonPath("$.response[4].name").value("Samsung"))
		.andExpect(jsonPath("$.response[4].price").value("20000.0"))
		.andExpect(jsonPath("$.response[4].status").value("AVAILABLE"))
		.andExpect(jsonPath("$.response[4].lineOfBusiness").value("RETAIL"))
		.andExpect(jsonPath("$.response[4].countryCode").value("KOR"))
		.andExpect(jsonPath("$.response[4].publicationDate").value("2020-07-22"))
		.andExpect(jsonPath("$.response[4].accessoryType").value("ALL"))
		
		.andExpect(jsonPath("$.response[18].id").value(21))
		.andExpect(jsonPath("$.response[18].name").value("Samsung XLS"))
		.andExpect(jsonPath("$.response[18].price").value("20000.0"))
		.andExpect(jsonPath("$.response[18].status").value("AVAILABLE"))
		.andExpect(jsonPath("$.response[18].lineOfBusiness").value("ONLINE"))
		.andExpect(jsonPath("$.response[18].countryCode").value("KOR"))
		.andExpect(jsonPath("$.response[18].publicationDate").value("2020-07-29"))
		.andExpect(jsonPath("$.response[18].accessoryType").value("ALL"))
		;
	}
	
	@WithMockUser(username = "mobile-service-user", password = "mobile-service-user", roles = "MOBILE_USER")
	@Test
	@Order(5)
	public void testSaveNewMobile() throws Exception {
		SaveMobileDto saveRequest = new SaveMobileDto();
		saveRequest.setName("IPHONE11+s");
		saveRequest.setStatus("AVAILABLE");
		saveRequest.setLineOfBusiness("ONLINE");
		saveRequest.setCountryCode("USA");
		saveRequest.setPrice(140000.0);
		saveRequest.setAccessoryType("ALL");
		
		String jsonString = new ObjectMapper().writeValueAsString(saveRequest);
		
		mvc.perform(
				post("/mobiles")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonString)
				)
		.andExpect(status().is(201))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.response", hasSize(21)))
		 //.andExpect(jsonPath("$.response[20].id").value(27))
		.andExpect(jsonPath("$.response[20].name").value("IPHONE11+s"))
		.andExpect(jsonPath("$.response[20].price").value("140000.0"))
		.andExpect(jsonPath("$.response[20].status").value("AVAILABLE"))
		.andExpect(jsonPath("$.response[20].lineOfBusiness").value("ONLINE"))
		.andExpect(jsonPath("$.response[20].countryCode").value("USA"))
		.andExpect(jsonPath("$.response[20].publicationDate").value(LocalDate.now().toString()))
		.andExpect(jsonPath("$.response[20].accessoryType").value("ALL"))
		;
	}
	
	@WithMockUser(username = "mobile-service-user", password = "mobile-service-user", roles = "MOBILE_USER")
	@Test
	@Order(6) 
	public void testDeleteById() throws Exception {
		
		MvcResult result =  mvc.perform(
				  get("/mobiles")
				  .accept(MediaType.APPLICATION_JSON)
				)
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		
		ObjectMapper mapper = new  ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
		
		
		Response<List<MobileDto>>  response = 	
				mapper
				.readValue(json, new TypeReference<Response<List<MobileDto>> >() {});
		
		MobileDto lastMobile = response.getResponse().get(response.getResponse().size()-1);
		
		mvc.perform(
				delete("/mobiles/"+lastMobile.getId())
				)
		.andExpect(status().is(202));
		
	}
	
	
}

