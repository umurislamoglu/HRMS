package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Resumes;

public interface ResumeService {

	DataResult<List<Resumes>> getByJobSeekerId(int id);

	Result add(Resumes resume);

}
