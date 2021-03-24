package proj.lak.userAuth.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import proj.lak.userAuth.entity.AuthRequest;
import proj.lak.userAuth.entity.InvalidUser;
import proj.lak.userAuth.entity.ValidUser;
import proj.lak.userAuth.repository.InvalidUserRepository;
import proj.lak.userAuth.repository.ValidUserRepository;
import proj.lak.userAuth.util.JwtUtil;

/**
 * @author LAKSHMI
 */

@RestController
public class WelcomeController {
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ValidUserRepository validUserRepository;
	
	@Autowired
	private InvalidUserRepository invalidUserRepository;	
	
		
	@GetMapping("/")
	public String welcome() {
		return "Hi there";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authrequest) throws Exception {
		boolean thrown = false;
		try {
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUserName(), authrequest.getPassword()));
			
		}
		catch (Exception e) {
			thrown = true;
			throw new Exception("Invalid username and password");
		}
		finally {
			Date date = new Date();  
			Timestamp timestamp = new Timestamp(date.getTime());  
			if(thrown) {
				InvalidUser iu = new InvalidUser();
				iu.setTimestamp(timestamp);
				iu.setUsername(authrequest.getUserName());
				invalidUserRepository.save(iu);
			}
			else {
				ValidUser vu = new ValidUser();
				vu.setTimestamp(timestamp);
				vu.setUsername(authrequest.getUserName());
				validUserRepository.save(vu);
			}
		}
		
		return jwtUtil.generateToken(authrequest.getUserName());
	}

}
