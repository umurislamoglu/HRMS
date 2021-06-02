package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "images")
public class JobSeekerImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	@Column(name="jobseekerid")
//	private int jobSeekerId;
	
	@Column(name="imageurl")
	private String imageUrl;
	
	@Column(name="imagename")
	private String imageName;
	
	@Column(name="cloudinaryid")
	private String cloudinaryId;
	
	@Column(name="uploaddate")
	private final Date uploadDate = new Date();
	
	@OneToOne
	@JoinColumn(name="jobseekerid")
	private JobSeekers jobSeeker;
	
	public JobSeekerImage(String imageName, String imageUrl, String cloudinaryId) {
		super();
		this.imageName = imageName;
		this.imageUrl = imageUrl;
		this.cloudinaryId = cloudinaryId;
	}
}
