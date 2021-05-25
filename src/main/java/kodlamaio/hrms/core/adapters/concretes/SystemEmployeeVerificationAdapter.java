package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.adapters.abstracts.SystemEmployeeVerification;
import kodlamaio.hrms.entities.concretes.Employers;

@Component
public class SystemEmployeeVerificationAdapter implements SystemEmployeeVerification {

	@Override
	public boolean verify(Employers employer) {
		
		return true;
	}

}
