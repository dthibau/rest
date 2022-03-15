package org.mediatheque.repository;

import java.util.Optional;

import org.mediatheque.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	@Query("from UserEntity u left join fetch u.emprunts where u.id=:id")
	Optional<UserEntity> fullLoad(@Param("id") int id);
}
