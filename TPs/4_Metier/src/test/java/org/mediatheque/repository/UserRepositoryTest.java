package org.mediatheque.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.mediatheque.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepositoy;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testFullLoad() {
		
		UserEntity userEntity = userRepositoy.fullLoad(1).get();
		
		// We close the session
		entityManager.close();
		
		// No Lazy Exception
		System.out.println(userEntity.getEmprunts().get(0).getExemplaires().get(0));
	}
}
