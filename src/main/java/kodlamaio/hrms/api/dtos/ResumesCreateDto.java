package kodlamaio.hrms.api.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.JobExperiences;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.concretes.Schools;
import kodlamaio.hrms.entities.concretes.Skills;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumesCreateDto {

private String coverLetter;
	
	private String githubAdress;
	
	private String linkedinAdress;
	
	private List<JobExperiences> jobExperiences;
	
	private List<Schools> schools;
	
	private List<Languages> languages;
	
	private List<Skills> skills;
}
