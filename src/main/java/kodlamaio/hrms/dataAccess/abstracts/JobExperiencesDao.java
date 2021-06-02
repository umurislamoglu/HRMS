package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobExperiences;

public interface JobExperiencesDao extends JpaRepository<JobExperiences,Integer> {
	List<JobExperiences> findAllByOrderByActiveStatusDescEndDateDesc();
}
