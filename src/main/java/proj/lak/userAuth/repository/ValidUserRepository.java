package proj.lak.userAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proj.lak.userAuth.entity.ValidUser;

/**
 * @author LAKSHMI
 */
public interface ValidUserRepository extends JpaRepository<ValidUser, Long>{

}
