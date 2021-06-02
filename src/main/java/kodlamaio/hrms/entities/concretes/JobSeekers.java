package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "jobseekers")

public class JobSeekers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	@Column(name="userid")
//	private int userId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="nationalid")
	private String nationalId;
	
	@Column(name="birthday")
	private LocalDate birthday;
	
	@OneToOne
	@JoinColumn(name = "userid", insertable = false, updatable = false)
	private Users users;
	
	@OneToMany(mappedBy = "jobSeeker")
    private List<Resumes> resumes;
	
	@OneToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private JobSeekerImage image;
	
}
