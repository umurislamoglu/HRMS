package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPositions;


@Service
public class JobPositionManager implements JobPositionService {

	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPositions>> getAll() {
		
		return new SuccessDataResult<List<JobPositions>>(jobPositionDao.findAll(),"Pozisyonlar listelendi");
				
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Result createJobPosition(JobPositions jobPosition) {
		boolean positionExists =jobPositionDao.findByPosition(jobPosition.getPosition()) !=null;
		
		if(positionExists) {
			return new ErrorResult("Pozisyon eklenmedi. Pozisyon zaten sistemde bulunmaktadır.");
		}else {
			jobPositionDao.save(jobPosition);
			return new SuccessResult("Pozisyon Eklendi");
		}
		
	}


	
}
