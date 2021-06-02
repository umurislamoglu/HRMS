package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.parser.ParseException;

import kodlamaio.hrms.api.dtos.ResumesCreateDto;
import kodlamaio.hrms.api.dtos.ResumesDto;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.mappers.ResumeMapper;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Resumes;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {
	
	private ResumeService resumeService;
	private ResumeMapper resumeMapper;
	
	@Autowired
	public ResumeController(ResumeMapper resumeMapper,ResumeService resumeService) {
		super();
		this.resumeMapper = resumeMapper;
		this.resumeService =resumeService;
	}
	
	@GetMapping("/getByJobSeekerId")
	public DataResult<List<ResumesDto>> getByJobSeekerId(@RequestParam int id) {
		List<ResumesDto> dataResult=resumeMapper.convertToDto(resumeService.getByJobSeekerId(id).getData());
		
		return new SuccessDataResult<List<ResumesDto>>(dataResult);
		
	}
	@PostMapping("/add")
	public Result add( @RequestBody ResumesCreateDto resumesCreateDto) throws ParseException {
		
		Resumes resume = resumeMapper.convertToCreateEntity(resumesCreateDto);
		
		return resumeService.add(resume);
		
	}

}
