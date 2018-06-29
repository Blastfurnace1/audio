package com.blastfurnace.otr.data.audiofile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blastfurnace.otr.data.audiofile.model.AudioFileProperties;


	// This will be AUTO IMPLEMENTED by Spring into a Bean called seriesRepository
	// CRUD refers Create, Read, Update, Delete

/** https://dzone.com/articles/accessing-the-entitymanager-from-spring-data-jpa

public class ParkrunCourseRepositoryImpl implements ParkrunCourseRepositoryCustom {

    @PersistenceContext

    private EntityManager em;

    @Override

    @Transactional

    public void refresh(ParkrunCourse parkrunCourse) {

        em.refresh(parkrunCourse);

    }

}


We must end our implementation name with “Impl”.

We then change the ParkrunCourseRepository interface to:

public interface ParkrunCourseRepository extends CrudRepository, ParkrunCourseRepositoryCustom {

}

**/

public interface AudioRepository extends JpaRepository<AudioFileProperties, Long>, AudioRepositoryCustom {
	
	public List<AudioFileProperties> findBySeriesIdAndEpisodeId(Long seriesId, Long episodeId);

	@Query("SELECT p FROM AudioFileProperties p WHERE p.directory = :directory AND p.filename = :filename AND p.discId = :discId")
	public List<AudioFileProperties> findByDirectoryFilenameAndDiscId(@Param("directory") String directory, @Param("filename") String filename, @Param("discId") String discId);
}


