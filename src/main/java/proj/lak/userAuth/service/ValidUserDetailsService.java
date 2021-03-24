package proj.lak.userAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.lak.userAuth.entity.ValidUser;
import proj.lak.userAuth.repository.ValidUserRepository;

/**
 * @author LAKSHMI
 */
@Service
public class ValidUserDetailsService {
	
	@Autowired
	ValidUserRepository validUserRepository;
	
	public List<ValidUser> listAll() {
        return validUserRepository.findAll();
    }
     
    public void save(ValidUser vu) {
    	validUserRepository.save(vu);
    }
     
    public ValidUser get(long id) {
        return validUserRepository.findById(id).get();
    }
     
    public void delete(long id) {
    	validUserRepository.deleteById(id);
    }
}
