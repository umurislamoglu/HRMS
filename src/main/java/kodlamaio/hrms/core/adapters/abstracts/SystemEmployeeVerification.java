package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.Employers;

public interface SystemEmployeeVerification {
	
	boolean verify(Employers employer);

}
