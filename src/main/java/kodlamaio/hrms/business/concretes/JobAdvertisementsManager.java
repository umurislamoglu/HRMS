package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.JobAdvertisementsService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementsDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;

@Service
public class JobAdvertisementsManager implements JobAdvertisementsService {

	private JobAdvertisementsDao jobAdvertisementsDao;

	@Autowired
	public JobAdvertisementsManager(JobAdvertisementsDao jobAdvertisementsDao) {
		super();
		this.jobAdvertisementsDao = jobAdvertisementsDao;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Result add(JobAdvertisements jobAdvertisement) {
		jobAdvertisementsDao.save(jobAdvertisement);
		return new SuccessResult("İlan eklendi.");
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActiveTrue() {

		return new SuccessDataResult<List<JobAdvertisements>>(jobAdvertisementsDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActiveTrueAndEmployer_companyName(String companyName) {

		return new SuccessDataResult<List<JobAdvertisements>>(
				jobAdvertisementsDao.getByIsActiveTrueAndEmployer_companyName( companyName));
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Result makePassive(int id) {
		JobAdvertisements user = jobAdvertisementsDao.findById(id).get();
		user.setActive(false);
		jobAdvertisementsDao.save(user);
		
		return new SuccessResult("İlan pasif hale getirildi.");
	}

	
	@Override
	public DataResult<List<JobAdvertisements>> getByIsActiveTrueOrderByDeadlineAsc() {
		
		return  new SuccessDataResult<List<JobAdvertisements>>(jobAdvertisementsDao.getByIsActiveTrueOrderByDeadlineAsc());
	}

}
