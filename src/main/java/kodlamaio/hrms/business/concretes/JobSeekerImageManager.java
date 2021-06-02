package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerImageService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerImageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerImage;

@Service
public class JobSeekerImageManager implements JobSeekerImageService {

	private JobSeekerImageDao jobSeekerImageDao;
	
	@Autowired
	public JobSeekerImageManager(JobSeekerImageDao jobSeekerImageDao) {
		super();
		this.jobSeekerImageDao = jobSeekerImageDao;
	}
	
	
	@Override
	public Result upload(JobSeekerImage jobSeekerImage) {
		jobSeekerImageDao.save(jobSeekerImage);
		return new SuccessResult("Fotograf yüklendi");
	}

}
