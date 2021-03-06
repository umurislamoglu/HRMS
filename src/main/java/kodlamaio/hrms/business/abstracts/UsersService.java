package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Users;

public interface UsersService {

	DataResult<List<Users>> getAll();
	
	Result createUser(Users users);
}
