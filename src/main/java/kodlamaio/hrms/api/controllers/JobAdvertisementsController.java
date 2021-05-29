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

import kodlamaio.hrms.business.abstracts.JobAdvertisementsService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementsService jobAdvertisementsService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementsService jobAdvertisementsService) {
		super();
		this.jobAdvertisementsService = jobAdvertisementsService;
	}
	
	@PostMapping("/add")
	public Result add( @RequestBody JobAdvertisements jobAdvertisement) {
		return jobAdvertisementsService.add(jobAdvertisement);
		
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisements>> getByIsActiveTrue() {
		return jobAdvertisementsService.getByIsActiveTrue();
		
	}
	
	@GetMapping("/getByIsActiveTrueOrderByDeadlineAsc")
	public DataResult<List<JobAdvertisements>> getByIsActiveTrueOrderByDeadlineAsc() {
		return jobAdvertisementsService.getByIsActiveTrueOrderByDeadlineAsc();
		
	}
	
	@GetMapping("/getByIsActiveTrueAndEmployer")
	public DataResult<List<JobAdvertisements>> getByIsActiveTrueAndEmployer_companyName(@RequestParam String companyName) {
		return jobAdvertisementsService.getByIsActiveTrueAndEmployer_companyName(companyName);
		
	}
	
	@PutMapping("/makepassive")
	public Result makePassive(@RequestParam int id) {
		return jobAdvertisementsService.makePassive(id);
		
	}

}
