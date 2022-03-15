package org.mediatheque.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

@DataJpaTest
public class MediaRepositoryTest {

	@Autowired
	MediaRepository mediaRepository;
	
	@Test
	public void testFind() {
		assertThat(mediaRepository.findAll().size()).isEqualTo(3);
		
		assertThat(mediaRepository.findMedia("",PageRequest.of(0, 10)).getContent().size()).isEqualTo(3);

		assertThat(mediaRepository.findMedia("grand",PageRequest.of(0, 10)).getContent().size()).isEqualTo(1);

		assertThat(mediaRepository.findDvds("grand",PageRequest.of(0, 10)).getContent().size()).isEqualTo(1);

		assertThat(mediaRepository.findBooks("grand",PageRequest.of(0, 10)).getContent().size()).isEqualTo(0);
		
		assertThat(mediaRepository.findBooks("",PageRequest.of(0, 10)).getContent().size()).isEqualTo(1);

	}
	
	@Test
	public void testDispo() {
		assertThat(mediaRepository.findExemplaireDisponible(1).size()).isGreaterThan(0);
		
		assertThat(mediaRepository.findExemplaireDisponible(3).size()).isEqualTo(0);

	}
}
