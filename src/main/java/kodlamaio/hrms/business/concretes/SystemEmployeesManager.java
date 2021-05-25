package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeesService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeesDao;
import kodlamaio.hrms.entities.concretes.SystemEmployees;

@Service
public class SystemEmployeesManager implements SystemEmployeesService {

	private SystemEmployeesDao systemEmployeesDao;

	@Autowired
	public SystemEmployeesManager(SystemEmployeesDao systemEmployeesDao) {
		super();
		this.systemEmployeesDao = systemEmployeesDao;
	}
	@Override
	public DataResult<List<SystemEmployees>> getAll() {
		
		return new SuccessDataResult<List<SystemEmployees>>(systemEmployeesDao.findAll(),"Sistem Personelleri listelendi");
				
	}

}
