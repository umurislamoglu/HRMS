package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "userid")
	private int userId;

	@Column(name = "website")
	private String website;

	@Column(name = "companyname")
	private String companyName;

	@Column(name = "phonenumber")
	private String phoneNumber;

	@OneToOne
	@JoinColumn(name = "userid", insertable = false, updatable = false)
	private Users users;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisements> jobAdvertisements;

}
