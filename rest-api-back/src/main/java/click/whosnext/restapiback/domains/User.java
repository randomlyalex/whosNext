package click.whosnext.restapiback.domains;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	@Column(name = "uuid", unique = true, nullable = false)
	private UUID uuid;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	public User( final String name, final String email ) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.email = email;
	}

	public void setUuid( final UUID uuid ) {
		this.uuid = uuid;
	}


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

	public String toString(){
		return String.format( "Name: %s %n Email: %s", this.name, this.email );
	}

}
