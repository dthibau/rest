package org.mediatheque.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.model.Emprunt;
import org.openapitools.model.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	UserService userService;

	Media m1 = new Media();
	Media m2 = new Media();
	Media m3 = new Media();
	
	@BeforeEach
	public void initMedias() {
		m1.setId(1l);
		m2.setId(2l);
		m3.setId(3l);
	}
	
	@Test
	public void givenDavidHas2EmpruntWhenEmprunt2ThenBusinessException() {
		List<Media> twoDispoMedia = new ArrayList<>();
		twoDispoMedia.add(m1);
		twoDispoMedia.add(m2);
		
		Assertions.assertThrows(BusinessException.class,
				() -> userService.doEmprunt(1, twoDispoMedia));
		
	}
	@Test
	public void givenLouiseHasNoEmpruntWhenEmprunt2ThenOk() throws BusinessException {
		List<Media> twoDispoMedia = new ArrayList<>();
		twoDispoMedia.add(m1);
		twoDispoMedia.add(m2);
		
		Emprunt emprunt = userService.doEmprunt(2, twoDispoMedia);
		
		assertThat(emprunt).isNotNull();

		
	}
	
	@Test
	public void givenNoDispoWhenEmpruntThenBusinessException() {
		List<Media> twoDispoMedia = new ArrayList<>();
		twoDispoMedia.add(m3);
		
		Assertions.assertThrows(BusinessException.class,
				() -> userService.doEmprunt(2, twoDispoMedia));
		
	}
}
