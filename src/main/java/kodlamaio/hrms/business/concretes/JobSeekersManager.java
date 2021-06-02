package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.core.adapters.abstracts.CheckUserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import kodlamaio.hrms.dataAccess.abstracts.UsersDao;
import kodlamaio.hrms.entities.concretes.JobSeekers;


@Service
public class JobSeekersManager implements JobSeekersService {

	private JobSeekersDao jobSeekersDao;
	private UsersDao usersDao;
	private CheckUserService checkUserService;

	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao,UsersDao usersDao,CheckUserService checkUserService) {
		super();
		this.jobSeekersDao = jobSeekersDao;
		this.usersDao=usersDao;
		this.checkUserService=checkUserService;
	}
	@Override
	public DataResult<List<JobSeekers>> getAll() {
		
		return new SuccessDataResult<List<JobSeekers>>(jobSeekersDao.findAll(),"İş Arayanlar listelendi");
				
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Result createJobSeeker(JobSeekers jobSeeker) {
		
		//Aday'ın user tablosunda bulunma şartı	
		boolean user = usersDao.findById(jobSeeker.getUsers().getId()).get() != null;
	
		//Tüm alanların dolu olması şartı
			//Database tarafında bütün alanlar not null olarak işaretlidir.
	
		//Mernis Doğrulaması
		boolean merniVerified = checkUserService.checkIfRealPerson(jobSeeker);
		
		if(!merniVerified)
			return new ErrorResult("Mernis Doğrulaması yapılamadı. Bilgilerinizi kontrol ediniz.");
		
		//E postanın ve TC'nin unique olma şartı
		//Eposta user kaydı yapıldığına göre uniquedır
		boolean NationalityIdExists =jobSeekersDao.findByNationalId(jobSeeker.getNationalId()) !=null;
		
		if(NationalityIdExists)
			return new ErrorResult("TC kimlik numarası sisteme kayıtlıdır.");
		
		//E-posta doğrulaması

		if (user && !NationalityIdExists && merniVerified ) {
			jobSeekersDao.save(jobSeeker);
			return new SuccessResult("Aday kaydedildi");}
			else {
				return new ErrorResult("Aday kaydı yapılamadı");
			}
		

		} 
	}


