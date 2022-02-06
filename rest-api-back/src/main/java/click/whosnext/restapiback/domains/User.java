package click.whosnext.restapiback.domains;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "users")
public class User {

	@Id
	@Column(name = "uuid")
	private UUID uuid = UUID.randomUUID();
	@Column(name = "name")
	private String name;
	@Column(name = "email", unique = true)
	private String email;

	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public void setName( final String name ) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( final String email ) {
		this.email = email;
	}



}
