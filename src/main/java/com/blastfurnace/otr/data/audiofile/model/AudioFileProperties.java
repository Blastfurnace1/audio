package com.blastfurnace.otr.data.audiofile.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.blastfurnace.otr.util.reflection.FieldProperties;
import com.blastfurnace.otr.util.reflection.Utils;

import lombok.Data;

@Entity
@XmlRootElement
@Table(name = "audio_file_properties", schema = "otr_mp3")
@Data
public class AudioFileProperties {
	
	// Get the names of all of the fields in the audio file properties class
	public static final List<FieldProperties> fieldDefinitions = Utils.getFieldNames(new AudioFileProperties());

	public AudioFileProperties () {}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@NotEmpty
	@Size(max = 20)
	@Column(name = "disc_id")
	private String discId = "";
	
	@NotNull
	@NotEmpty
	private String directory = "";
	
	@NotNull
	@NotEmpty
	@Size(max = 150)
	@Column(name = "file_name")
	private String filename = "";
	
	@NotNull
	@NotEmpty
	@Column(name = "file_type")
	private String fileType = "";
	
	// bitrate kilobytes per second
	@NotNull
	private Integer bitrate = 0;
	
	@NotNull
	@Column(name = "audio_sampling_rate")
	private Integer audioSamplingRate = 0;
	
	// Number of Audio Channels
	@NotNull
	@Column(name = "audio_channels")
	private Integer audioChannels = 0;
	
	// duration minutes
	@NotNull
	private Integer duration = 0;

	// duration seconds + fractions
	@NotNull
	@Column(name = "precise_duration")
	private Float preciseDuration = 0.0f;
	
	@NotNull
	@Column(name = "file_length")
	private Long fileLength = 0l;
	
	@NotNull
	private Integer zipped = 0;
	
	@NotNull
	@Column(name = "zip_file")
	private String zipFile = "";
	
	@NotNull
	@Column(name = "audio_file")
	private Integer audioFile	= 0;
	
	@NotNull
	@NotEmpty
	@Column(name = "encoding_type")
	private String encodingType = "Non MP3 File";
	
	@NotNull
	@Column(name = "extra_encode_info")
	private String extraEncodeInfo = "";
	
	@NotNull
	@Column(name = "variable_bitrate")
	private Integer variableBitrate	= 0;
	
	@NotNull
	@Column(name = "series_id")
	private Long seriesId	= 0l;
	
	@NotNull
	@Column(name = "episode_id")
	private Long episodeId	= 0l;
	
	@NotNull
	@Column(name = "source_id")
	private Integer sourceId	= 0;
	
	@NotNull
	private String description = "";
	
	@NotNull
	private Integer rating	= 0;
	
	@NotNull
	private Integer heard	= 0;
	
	@NotNull
	@Column(name = "audio_quality")
	private Integer audioQuality	= 0;
	
	@NotNull
	@Column(name = "encoding_quality")
	private Integer encodingQuality	= 0;
	
	@NotNull
	@Column(name = "media_id")
	private Integer mediaId	= 0;
	
	@NotNull
	private String genre = "";

	@NotNull
	private String title = "";

	@Column(name = "track_no")
	private String trackNo = "";

	@NotNull
	private String year = "";

	@NotNull
	private String album = "";

	@NotNull
	private String artist = "";

	@NotNull
	private String comment = "";

	@NotNull
	private Integer indexed	= 0;
	
	@NotNull
	@Column(name = "series_name")
	private String seriesName = "";
	
	@NotNull
	@Column(name = "episode_name")
	private String episodeName = "";
	
	@NotNull
	@Column(name = "episode_number")
	private Integer episodeNumber = 0;
	
	@NotNull
	@Column(name = "broadcast_date")
	private String broadcastDate = "";
	
	@NotNull
	@Column(name = "request_count")
	private Long requestCount = 0l;
	
	@NotNull
	@Column(name = "last_requested")
	private Date lastRequested = new Date();
	
	/** Update-able fields for a record update. */
	public void updateAudioFile(AudioFileProperties newAudio) {
		this.seriesId = newAudio.getSeriesId();
		this.episodeId = newAudio.getEpisodeId();
		this.sourceId = newAudio.getSourceId();
		this.description = newAudio.getDescription();
		this.rating	= newAudio.getRating();
		this.heard = newAudio.getHeard();
		this.audioQuality = newAudio.getAudioQuality();
		this.encodingQuality = newAudio.getEncodingQuality();
		this.mediaId = newAudio.getMediaId();
		this.genre = newAudio.getGenre();
		this.title = newAudio.getTitle();
		this.trackNo = newAudio.getTrackNo();
		this.year = newAudio.getYear();
		this.album = newAudio.getAlbum();
		this.artist = newAudio.getArtist();
		this.comment = newAudio.getComment();
	}
}
