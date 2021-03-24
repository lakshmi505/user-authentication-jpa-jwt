package proj.lak.userAuth.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LAKSHMI
 */
@Entity
@Table(name ="user")
public class User {
	
	@Id
	private String id;
	private String userName;
	private String password;
	
	public User(String id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	

	public User() {
		
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}