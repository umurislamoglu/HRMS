package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Resumes;

public interface ResumesDao extends JpaRepository<Resumes,Integer> {

	List<Resumes> findByJobSeeker_IdOrderBySchools_ActiveStatusDescSchools_EndDateDescJobExperiences_ActiveStatusDescJobExperiences_EndDateDesc(int id);
}
