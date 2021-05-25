package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.entities.concretes.JobPositions;

public interface JobPositionDao extends JpaRepository<JobPositions,Integer> {
	 
	@Query(value="SELECT id,position FROM jobpositions j WHERE j.position = ?1", nativeQuery = true)
	    JobPositions findByPosition(String position);
}
