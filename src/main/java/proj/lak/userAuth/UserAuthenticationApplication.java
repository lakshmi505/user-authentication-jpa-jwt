package proj.lak.userAuth;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import proj.lak.userAuth.entity.User;
import proj.lak.userAuth.repository.UserRepository;

@SpringBootApplication
public class UserAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationApplication.class, args);
	}

	@Autowired
	private UserRepository repository;
	

	@PostConstruct
	public void initUsers()
	{
		   List<User> users = Stream.of(
	                new User("2", "manasa", "123"),new User("3", "siri", "123")	                
	        ).collect(Collectors.toList());
	        repository.saveAll(users);
	}
}
