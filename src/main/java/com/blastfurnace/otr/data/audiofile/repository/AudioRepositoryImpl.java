/*
 */
package com.blastfurnace.otr.data.audiofile.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.blastfurnace.otr.data.audiofile.model.AudioFileProperties;
import com.blastfurnace.otr.data.respository.generic.GenericRepository;
import com.blastfurnace.otr.rest.request.QueryData;

import java.util.List;

public class AudioRepositoryImpl implements AudioRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	/** implements the underlying functionality. */
	private GenericRepository<AudioFileProperties> audioRepo = new GenericRepository<AudioFileProperties>(AudioFileProperties.class, AudioFileProperties.fieldDefinitions);

	@Override
	@Transactional
	public Long getRecordCount(QueryData queryData) {
		return audioRepo.getRecordCount(em, queryData);
	}

	@Override
	@Transactional
	public List<AudioFileProperties> find(QueryData queryData) {
		return audioRepo.find(em, queryData);
	}

	public List<AudioFileProperties> find() {
		return audioRepo.find(em);
	}

}
