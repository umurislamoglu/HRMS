package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jobexperiences")
public class JobExperiences {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	@Column(name="resumeid")
//	private int resumeId;
	
	@Column(name="workplacename")
	private String workPlaceName;
	
	@Column(name="workposition")
	private String workPosition;
	
	@Column(name="startdate")
	private LocalDate startDate;

	@Column(name="enddate")
	private LocalDate endDate;
	
	@Column(name="creationdate")
	@JsonIgnore
	private final Date ceationDate= new Date();
	
	@Column(name = "activestatus")
	private boolean activeStatus;
	
	@ManyToOne
	@JoinColumn(name = "resumeid")
	@JsonIgnore
	private Resumes resume;
}
