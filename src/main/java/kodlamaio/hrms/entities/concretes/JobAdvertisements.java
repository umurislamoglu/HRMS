package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobadvertisements")
public class JobAdvertisements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	//@Column(name="employerid")
	//private int employerId;

	//@Column(name="positionid")
	//private int positionId;

	@Column(name="positiondefinition")
	private String positionDefinition;

	@Column(name="city")
	private String city;
	
	@Column(name="salarymin")
	private int salaryMin;
	
	@Column(name="salarymax")
	private int salaryMax;
	
	@Column(name="vacancy")
	private int vacancy;
	
	@Column(name="deadline")
	private LocalDate deadline;
	
	@Column(name="isactive")
	private boolean isActive;
	
	
	@ManyToOne
	@JoinColumn(name= "employerid")
	private Employers employer;
	
	@OneToOne
	@JoinColumn(name = "positionid")
	private JobPositions jobPosition;

	
}
