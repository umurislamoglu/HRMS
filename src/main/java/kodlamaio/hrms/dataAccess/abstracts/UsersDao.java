package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.hrms.entities.concretes.Users;

public interface UsersDao extends JpaRepository<Users,Integer>{
	
	@Query(value="SELECT * FROM users u WHERE u.email = ?1", nativeQuery = true)
    Users findByEmail(String email);
}
