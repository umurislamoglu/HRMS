package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.parser.ParseException;

import kodlamaio.hrms.api.dtos.JobAdvertisementsCreateDto;
import kodlamaio.hrms.api.dtos.JobAdvertisementsDto;
import kodlamaio.hrms.business.abstracts.JobAdvertisementsService;
import kodlamaio.hrms.core.mappers.JobAdvertisementMapper;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;


@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementsService jobAdvertisementsService;
	private JobAdvertisementMapper jobAdvertisementMapper;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementsService jobAdvertisementsService,JobAdvertisementMapper jobAdvertisementMapper) {
		super();
		this.jobAdvertisementsService = jobAdvertisementsService;
		this.jobAdvertisementMapper = jobAdvertisementMapper;
	}
	
	@PostMapping("/add")
	public Result add( @RequestBody JobAdvertisementsCreateDto jobAdvertisementsCreateDto) throws ParseException {
//		JobAdvertisements jobAdvertisement = new JobAdvertisements();

//		jobAdvertisement.setCity(jobAdvertisementsCreateDto.getCity());
//		jobAdvertisement.setDeadline(jobAdvertisementsCreateDto.getDeadline());
//		jobAdvertisement.setSalaryMax(jobAdvertisementsCreateDto.getSalaryMax());
//		jobAdvertisement.setSalaryMin(jobAdvertisementsCreateDto.getSalaryMin());
//		jobAdvertisement.setPositionDefinition(jobAdvertisementsCreateDto.getPositionDefinition());
//		jobAdvertisement.setVacancy(jobAdvertisementsCreateDto.getVacancy());
//		jobAdvertisement.setEmployer(employersService.getbyId(jobAdvertisementsCreateDto.getEmployerId()).getData());
		
		JobAdvertisements jobAdvertisement = jobAdvertisementMapper.convertToCreateEntity(jobAdvertisementsCreateDto);
		
		return jobAdvertisementsService.add(jobAdvertisement);
		
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisementsDto>> getByIsActiveTrue() {
		List<JobAdvertisementsDto> dataResult=jobAdvertisementMapper.convertToDto(jobAdvertisementsService.getByIsActiveTrue().getData());
		
		return new SuccessDataResult<List<JobAdvertisementsDto>>(dataResult);
		
	}
	
	@GetMapping("/getByIsActiveTrueOrderByDeadlineAsc")
	public DataResult<List<JobAdvertisementsDto>> getByIsActiveTrueOrderByDeadlineAsc() {
		
		List<JobAdvertisementsDto> dataResult=jobAdvertisementMapper.convertToDto(jobAdvertisementsService.getByIsActiveTrueOrderByDeadlineAsc().getData());
		
		return new SuccessDataResult<List<JobAdvertisementsDto>>(dataResult);
		
	}
	
	@GetMapping("/getByIsActiveTrueAndEmployer")
	public DataResult<List<JobAdvertisementsDto>> getByIsActiveTrueAndEmployer_companyName(@RequestParam String companyName) {
		
		List<JobAdvertisementsDto> dataResult=jobAdvertisementMapper.convertToDto(jobAdvertisementsService.getByIsActiveTrueAndEmployer_companyName(companyName).getData());
		
		return new SuccessDataResult<List<JobAdvertisementsDto>>(dataResult);
		
	}
	
	@PutMapping("/makepassive")
	public Result makePassive(@RequestParam int id) {
		return jobAdvertisementsService.makePassive(id);
		
	}
	
	  

}
