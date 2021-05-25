package kodlamaio.hrms.entities.concretes;



import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "systememployees")
public class SystemEmployees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="userid")
	private int userId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="positionid")
	private int positionId;
	
	@OneToOne
	@JoinColumn(name = "userid", insertable = false, updatable = false)
	private Users users;
	
	@OneToOne
	@JoinColumn(name = "positionid", insertable = false, updatable = false)
	private JobPositions jobPositions;
}
