package com.blastfurnace.otr.data.audiofile;

import java.util.List;

import com.blastfurnace.otr.data.ATypicalDataService;
import com.blastfurnace.otr.data.audiofile.model.AudioFileProperties;

public interface AudioService extends ATypicalDataService<AudioFileProperties> {
	
	public List<AudioFileProperties> findByDirectoryFilenameAndDiscId(String directory, String filename, String discId);

}