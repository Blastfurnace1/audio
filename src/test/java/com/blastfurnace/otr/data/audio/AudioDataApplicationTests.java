/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blastfurnace.otr.data.audio;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.blastfurnace.otr.data.audiofile.AudioService;
import com.blastfurnace.otr.data.audiofile.model.AudioFileProperties;
import com.blastfurnace.otr.utils.UtilitiesApplicationTest;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * Integration Tests for Audio Services
 *
 * @author Jim Blackson
 */

public class AudioDataApplicationTests extends UtilitiesApplicationTest {

	
	@Autowired
	AudioService audioService;
	
	
	/** Get a new AudioFileProperties Object. */
	private AudioFileProperties getNewAudioFileProperties() {
		AudioFileProperties afp = new AudioFileProperties();
		afp.setDirectory("C:/temp");
		afp.setFilename("Duuger.txt");
		afp.setDiscId("MPX_1");
		afp.setFileType("MPX");
		return afp;
	}
	
	
	
	@Test
	/** Test Data Access for Audio file Properties. */
	public void shouldPerformAudioFilePropertiesRecordActions() throws Exception {
		
		AudioFileProperties afp = getNewAudioFileProperties();
		// add
		AudioFileProperties newAfp = audioService.save(afp);
		then(newAfp.getEncodingType().equals(afp.getEncodingType()));
		// get
		newAfp = audioService.get(newAfp.getId());
		then(newAfp.getEncodingType().equals(afp.getEncodingType()));
		// delete
		audioService.delete(newAfp.getId());
		// make sure its deleted
		newAfp = audioService.get(newAfp.getId());
		then(null == newAfp);
	}
}
