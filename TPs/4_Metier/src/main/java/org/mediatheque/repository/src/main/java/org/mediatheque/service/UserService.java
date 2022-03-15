package org.mediatheque.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.mediatheque.model.EmpruntEntity;
import org.mediatheque.model.ExemplaireEntity;
import org.mediatheque.model.UserEntity;
import org.mediatheque.repository.MediaRepository;
import org.mediatheque.repository.UserRepository;
import org.openapitools.model.Emprunt;
import org.openapitools.model.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

	
	public Emprunt doEmprunt(Integer idUser, List<Media> medias) throws BusinessException {
	
		return null;
	}
}
