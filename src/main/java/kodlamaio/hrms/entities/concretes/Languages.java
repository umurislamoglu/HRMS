package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="languages")
public class Languages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="languagename")
	private String languageName;

	@Min(1)
	@Max(5)
	@Column(name="languagelevel")
	private int languageLevel;
	
	@Column(name="creationdate")
	@JsonIgnore
	private final Date ceationDate= new Date();
	
	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false )
	@JsonIgnore
	private Resumes resume;
	
}
