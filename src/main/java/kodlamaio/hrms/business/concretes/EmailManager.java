package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.Users;

public class EmailManager implements EmailService {

	@Override
	public Result sendActivationCode(Users user) {
		String message = "Email başarı ile gönderildi : "+user.getEmail();
		return new SuccessResult(message);
	}

}
