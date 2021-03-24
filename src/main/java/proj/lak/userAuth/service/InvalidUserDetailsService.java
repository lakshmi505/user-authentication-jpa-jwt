package proj.lak.userAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.lak.userAuth.entity.InvalidUser;
import proj.lak.userAuth.repository.InvalidUserRepository;

/**
 * @author LAKSHMI
 */

@Service
public class InvalidUserDetailsService {
	
	@Autowired
	InvalidUserRepository invalidUserRepository;
	
	public List<InvalidUser> listAll() {
        return invalidUserRepository.findAll();
    }
     
    public void save(InvalidUser iu) {
    	invalidUserRepository.save(iu);
    }
     
    public InvalidUser get(long id) {
        return invalidUserRepository.findById(id).get();
    }
     
    public void delete(long id) {
    	invalidUserRepository.deleteById(id);
    }

}
