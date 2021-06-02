package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="skillname")
	private String skillName;
	
	@Column(name="creationdate")
	@JsonIgnore
	private final Date ceationDate= new Date();
	
	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false )
	@JsonIgnore
	private Resumes resume;
	
}
