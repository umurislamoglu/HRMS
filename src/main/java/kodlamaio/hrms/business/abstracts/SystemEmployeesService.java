package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.SystemEmployees;

public interface SystemEmployeesService {
	DataResult<List<SystemEmployees>> getAll();
}
