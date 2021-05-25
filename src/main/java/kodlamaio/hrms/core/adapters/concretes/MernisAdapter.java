package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.adapters.abstracts.CheckUserService;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.mernis.DPAKPSPublicSoap;

@Component
public class MernisAdapter implements CheckUserService {


	@Override
	public boolean checkIfRealPerson(JobSeekers jobSeeker) {
		DPAKPSPublicSoap service = new DPAKPSPublicSoap();
		boolean result =false;
		
		  try {
	            result = service.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalId()),
	            		jobSeeker.getFirstName(),
	            		jobSeeker.getLastName(),
	            		jobSeeker.getBirthday().getYear());
	            		
	            		
	            		
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	}
	}



