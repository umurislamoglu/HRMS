package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeekers;

public interface CheckUserService {
	boolean checkIfRealPerson(JobSeekers jobSeeker);
}
	
