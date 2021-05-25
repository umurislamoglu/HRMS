package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemEmployeesService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.SystemEmployees;

@RestController
@RequestMapping("api/systememployees")
public class SystemEmployeesController {

	private SystemEmployeesService systemEmployeesService;

	@Autowired
	public SystemEmployeesController(SystemEmployeesService systemEmployeesService) {
		super();
		this.systemEmployeesService = systemEmployeesService;
	}
	@GetMapping("/getall")
	public DataResult<List<SystemEmployees>> getAll(){
		return systemEmployeesService.getAll();
		
	}
}
