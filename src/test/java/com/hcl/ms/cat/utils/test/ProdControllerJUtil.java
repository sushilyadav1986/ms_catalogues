/**
 * 
 */
package com.hcl.ms.cat.utils.test;

import java.io.IOException;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.ms.cat.CatalogueMsApplication;

/**
 * JUnit Helper class for ProductControllerTest Initialize MockMvc
 * 
 * @author SushilY
 *
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CatalogueMsApplication.class)
public class ProdControllerJUtil {

	protected MockMvc mvc;

	@Autowired
	WebApplicationContext webAppCtx;

	/**
	 * Initialize MocMvc Object
	 *
	 */
	protected void init() {
		mvc = MockMvcBuilders.webAppContextSetup(webAppCtx).build();
	}

	/**
	 * @param object Change Object into String
	 *
	 */
	protected String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	/**
	 * @param json
	 * @param clas
	 * @return <T>
	 *
	 */

	protected <T> T mapFromJson(String json, Class<T> clas)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clas);
	}

	/**
	 * Return value from API
	 * 
	 * @param inputJson
	 * @param uri
	 * @return int
	 *
	 */
	public int callApi(String inputJson, String uri) {
		int status = 0;
		try {
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
					.andReturn();
			status = mvcResult.getResponse().getStatus();
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return status;
		}
	}

}
