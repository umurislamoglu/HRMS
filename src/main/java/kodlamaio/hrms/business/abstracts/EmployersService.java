package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersService {
	DataResult<List<Employers>> getAll();
	
	Result createEmployer(Employers employer);
}
