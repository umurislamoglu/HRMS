package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.hrms.entities.concretes.JobSeekers;


public interface JobSeekersDao  extends JpaRepository<JobSeekers,Integer> {
	@Query(value="SELECT id,nationalid FROM jobseekers j WHERE j.nationalid = ?1", nativeQuery = true)
    JobSeekers findByNationalId(String nationalId);
}
