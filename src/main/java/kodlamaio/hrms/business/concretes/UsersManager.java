package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UsersService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UsersDao;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class UsersManager implements UsersService {

	private UsersDao usersDao;

	@Autowired
	public UsersManager(UsersDao usersDao) {
		super();
		this.usersDao = usersDao;
	}
	@Override
	public DataResult<List<Users>> getAll() {
		
		return new SuccessDataResult<List<Users>>(usersDao.findAll(),"Kullanıcılar listelendi");
				
	}
	@Override
	public Result createUser(Users users) {
	
		boolean isPwMatched=users.getPassword().equals(users.getPasswordConfirmed());
	
		
		if(!isPwMatched)
			return new ErrorResult("Parola uyuşmadı.");
		
		boolean emailExists  =usersDao.findByEmail(users.getEmail()) != null;
		
				if((!emailExists)&&isPwMatched) {
					usersDao.save(users);
					return new SuccessResult("Kullanıcı oluşturuldu");
				} else {
					return new ErrorResult("Kullanıcı oluşturma başarısız");
				}
	}

}
