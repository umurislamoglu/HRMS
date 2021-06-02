package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerImage;

public interface JobSeekerImageService {
	
	Result upload(JobSeekerImage jobSeekerImage);

}
