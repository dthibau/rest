package org.mediatheque.repository;

import java.util.List;

import org.mediatheque.model.DVDEntity;
import org.mediatheque.model.ExemplaireEntity;
import org.mediatheque.model.MediaEntity;
import org.openapitools.model.Exemplaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MediaRepository extends JpaRepository<MediaEntity, Integer> {

	@Query("from MediaEntity m where m.titre like %:q%")
	Page<MediaEntity> findMedia(@Param("q") String q, Pageable pageable);
	
	@Query("from DVDEntity m where m.titre like %:q%")
	Page<DVDEntity> findDvds(@Param("q") String q, Pageable pageable);
	
	@Query("from CDEntity m where m.titre like %:q%")
	Page<DVDEntity> findCds(@Param("q") String q, Pageable pageable);
	
	@Query("from BookEntity m where m.titre like %:q%")
	Page<DVDEntity> findBooks(@Param("q") String q, Pageable pageable);
	
	@Query("from ExemplaireEntity ex where ex.media.id = :idMedia and ex.id NOT IN (select ex2.id from ExemplaireEntity ex2 where ex2.emprunt is not null)")
	List<ExemplaireEntity> findExemplaireDisponible(Integer idMedia);
}
