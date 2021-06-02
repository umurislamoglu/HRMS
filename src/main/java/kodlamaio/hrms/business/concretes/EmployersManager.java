package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.adapters.concretes.SystemEmployeeVerificationAdapter;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.dataAccess.abstracts.UsersDao;
import kodlamaio.hrms.entities.concretes.Employers;


@Service
public class EmployersManager implements EmployersService {

	private EmployersDao employersDao;
	private UsersDao	usersDao;
	private SystemEmployeeVerificationAdapter systemEmployeeVerificationAdapter;
	

	@Autowired
	public EmployersManager(EmployersDao employersDao, UsersDao	usersDao,SystemEmployeeVerificationAdapter systemEmployeeVerificationAdapter ) {
		super();
		this.employersDao = employersDao;
		this.usersDao=usersDao;
		this.systemEmployeeVerificationAdapter =systemEmployeeVerificationAdapter;
	
	}

	@Override
	public DataResult<List<Employers>> getAll() {
		
		return new SuccessDataResult<List<Employers>>(employersDao.findAll(),"İşverenler Listelendi");
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Result createEmployer(Employers employers) {
		
		//Employer'ın user tablosunda bulunma şartı
		boolean user = usersDao.findById(employers.getUserId()).get() !=null;
		
		//Tüm alanların dolu olması şartı
			//Database tarafında bütün alanlar not null olarak işaretlidir.
		
		//E-posta doğrulaması (System employee tarfından)
		boolean systemVerification = systemEmployeeVerificationAdapter.verify(employers);
		if(!systemVerification)
			return new ErrorResult("Sistem çalışanı tarafından kayıt iptal edildi.");
		
		//E postanın unique olma şartı
		//Eposta user kaydı yapıldığına göre uniquedır
		
		//Emaildeki domain ile websitesinin aynı olması
		boolean domainCheck = usersDao.findById(employers.getUserId()).get().getEmail().contains(employers.getWebsite());
		if(!domainCheck)
			return new ErrorResult("eposta adresi ile internet sitesi uyumlu olmalıdır.");

		if (user  && domainCheck && systemVerification) {
			employersDao.save(employers);
			return new SuccessResult("İşveren kaydedildi");
		} else {
			return new ErrorResult("işveren kaydı yapılamadı");
		}
	
	}

	@Override
	public DataResult<Employers> getbyId(int id) {
		
		return new SuccessDataResult<Employers>(employersDao.findById(id).get());
	}
}
