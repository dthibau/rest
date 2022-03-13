package org.mediatheque.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mediatheque.repository.MediaRepository;
import org.mediatheque.service.UserService;
import org.openapitools.model.Emprunt;
import org.openapitools.model.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = EmpruntController.class)
public class EmpruntControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	UserService userService;
	
	@MockBean
	MediaRepository mediaRepository;
	
	Media m1 = new Media();
	Media m2 = new Media();
	Media m3 = new Media();
	
	Emprunt emprunt = new Emprunt();
	
	@BeforeEach
	public void initMedias() {
		m1.setId(1l);
		m2.setId(2l);
		m3.setId(3l);
		
		emprunt.setId(1l);
	}
	
	@Test
	public void whenEmpruntReturnCreated() throws Exception {
		List<Media> medias = new ArrayList<>();
		medias.add(m1);
		medias.add(m2);
		medias.add(m3);
		
		given(this.userService.doEmprunt(1, medias)).willReturn(emprunt);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(medias);
		
		mvc.perform(post("/v1/emprunts/1").content(jsonString).contentType(MediaType.APPLICATION_JSON))
		                     .andExpect(status().isCreated())
		                     .andExpect(jsonPath("$.id").exists());

	}
}
