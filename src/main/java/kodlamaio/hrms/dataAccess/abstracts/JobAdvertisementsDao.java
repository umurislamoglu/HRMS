package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisements;


public interface JobAdvertisementsDao extends JpaRepository<JobAdvertisements,Integer> {
	
	List<JobAdvertisements> getByIsActiveTrue();
	
	List<JobAdvertisements> getByIsActiveTrueAndEmployer_companyName(String companyName);
	
	List<JobAdvertisements> getByIsActiveTrueOrderByDeadlineAsc();

}
