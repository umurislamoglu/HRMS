package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Users;

public interface EmailService {
	Result sendActivationCode(Users user);
}
