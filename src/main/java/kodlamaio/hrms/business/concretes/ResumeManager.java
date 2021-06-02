package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumesDao;
import kodlamaio.hrms.entities.concretes.Resumes;

@Service
public class ResumeManager implements ResumeService {

	private ResumesDao resumeDao;

	@Autowired
	public ResumeManager(ResumesDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public DataResult<List<Resumes>> getByJobSeekerId(int id) {

		return new SuccessDataResult<List<Resumes>>( resumeDao.findByJobSeeker_IdOrderBySchools_ActiveStatusDescSchools_EndDateDescJobExperiences_ActiveStatusDescJobExperiences_EndDateDesc(id));
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Result add(Resumes resume) {
		resumeDao.save(resume);
		return new SuccessResult("Özgeçmiş eklendi.");
	}

}
