package com.blastfurnace.otr.data.audiofile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blastfurnace.otr.data.audiofile.AudioService;
import com.blastfurnace.otr.data.audiofile.model.AudioFileProperties;
import com.blastfurnace.otr.data.audiofile.repository.AudioRepository;
import com.blastfurnace.otr.rest.request.QueryData;

@Component("AudioService")
public class AudioServiceImpl implements AudioService {

	@Autowired
	private AudioRepository repository;
	
	@Override
	public Long getResultsCount(QueryData qry) {
		return repository.getRecordCount(qry);
	}

	@Override
	public Iterable<AudioFileProperties> query(QueryData qry) {
		return repository.find(qry);
	}

	@Override
	public AudioFileProperties get(Long id) {
		
		Optional<AudioFileProperties> audio = repository.findById(id);
		if (audio.isPresent()) {
			return audio.get();
		} 
		
		return null;
	}

	@Override
	public void delete(Long  id) {
		repository.deleteById(id);
	}

	@Override
	public AudioFileProperties save(AudioFileProperties series) {
		return repository.save(series);
	}

	@Override
	public List<AudioFileProperties> findByDirectoryFilenameAndDiscId(String directory, String filename,
			String discId) {
		
		return repository.findByDirectoryFilenameAndDiscId(directory, filename, discId);
	}
}
