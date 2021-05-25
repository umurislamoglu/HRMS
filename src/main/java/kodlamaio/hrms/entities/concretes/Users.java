package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;


import lombok.Data;


@Entity
@Data
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email", length =50)
	private String email;
	
	@Column(name="password", length =50)
	private String password;
	
	@Transient
	private String passwordConfirmed;
	
	@Column(name="usertype", length =50)
	private String userType;
	
	@Column(name="isactive")
	private boolean isActive;
	

}
