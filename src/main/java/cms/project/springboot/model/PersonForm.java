package cms.project.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user")
public class PersonForm {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String username;
    
    @NotBlank
    private String password;
    private Boolean enabled;
    public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonForm(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "PersonForm [email=" + email + ", username=" + username + ", password=" + password + "]";
	} 
public PersonForm(){
	
}

}
