package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;

public interface JobAdvertisementsService {
	
	Result add(JobAdvertisements jobAdvertisement);
	
	DataResult<List<JobAdvertisements>> getByIsActiveTrue();
	
	DataResult<List<JobAdvertisements>> getByIsActiveTrueOrderByDeadlineAsc();

	DataResult<List<JobAdvertisements>> getByIsActiveTrueAndEmployer_companyName(String companyName);
	
	Result makePassive(int id);
}
