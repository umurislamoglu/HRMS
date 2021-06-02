package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="skills")

public class Resumes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	private int jobSeekerId;
//
//	private int schoolId;
//	
//	private int jobExperienceId;
//	
//	private int languageId;
//	
//	private int skillId;
	
	@Column(name="githubadress")
	private String githubAdress;
	
	@Column(name="linkedinadress")
	private String linkedinAdress;
	
	@Column(name="coverletter")
	private String coverLetter;
	
	@Column(name="creationdate")
	@JsonIgnore
	private final Date ceationDate= new Date();
	
	@OneToMany(mappedBy = "resume")
    private List<JobExperiences> jobExperiences;

    @OneToMany(mappedBy = "resume")
    private List<Schools> schools;

    @OneToMany(mappedBy = "resume")
    private List<Languages> languages;

    @OneToMany(mappedBy = "resume")
    private List<Skills> skills;
    
    @ManyToOne
	@JoinColumn(name = "jobseekerid")
	private JobSeekers jobSeeker;
}
