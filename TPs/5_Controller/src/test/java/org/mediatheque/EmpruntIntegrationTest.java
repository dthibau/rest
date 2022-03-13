package org.mediatheque;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.model.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class EmpruntIntegrationTest {

	@Autowired
	WebApplicationContext context;

	MockMvc mvc;

	Media bookBaru = new Media();
	Media dvdDelepine = new Media();
	Media cdTaha = new Media();

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		bookBaru.setId(1l);
		dvdDelepine.setId(2l);
		cdTaha.setId(3l);

	}

	@Test
	public void givenLouiseHasNoEmpruntwhenEmprun2MediaReturnCreated() throws Exception {
		List<Media> medias = new ArrayList<>();
		medias.add(bookBaru);
		medias.add(dvdDelepine);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(medias);

		mvc.perform(post("/v1/emprunts/2").content(jsonString).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.id").exists());

	}
	
	@Test
	public void givenDavideHasEmpruntwhenGetReturnHisEmprunts() throws Exception {
		List<Media> medias = new ArrayList<>();
		medias.add(bookBaru);
		medias.add(dvdDelepine);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(medias);

		mvc.perform(get("/v1/emprunts/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").exists());

	}

	@Test
	public void givenDavideHas2EmpruntwhenEmprun2MediaReturnCreated() throws Exception {
		List<Media> medias = new ArrayList<>();
		medias.add(bookBaru);
		medias.add(dvdDelepine);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(medias);

		mvc.perform(post("/v1/emprunts/1").content(jsonString).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isPreconditionFailed());

	}
	
	@Test
	public void givenTahasIsNotAvailableWhenLousieEmpruntTahaReturnPreConditionFailed() throws Exception {
		List<Media> medias = new ArrayList<>();
		medias.add(cdTaha);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(medias);

		mvc.perform(post("/v1/emprunts/2").content(jsonString).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isPreconditionFailed());

	}
	
	@Test
	public void whenBadUserReturn404() throws Exception {
		List<Media> medias = new ArrayList<>();
		medias.add(cdTaha);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(medias);

		mvc.perform(get("/v1/emprunts/999").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

	}
	

}
