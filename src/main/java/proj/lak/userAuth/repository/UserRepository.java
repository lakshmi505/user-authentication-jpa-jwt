package proj.lak.userAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proj.lak.userAuth.entity.User;

/**
 * @author LAKSHMI
 */
public interface UserRepository extends JpaRepository<User, String> {
	User findByUserName(String username);

}
