package click.whosnext.restapiback.domains;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	public User( final String name, final String email ) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.email = email;
	}

	public User( UUID uuid, final String name, final String email ) {
		this.uuid = uuid;
		this.name = name;
		this.email = email;
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

	@OneToMany(mappedBy = "user")
	private Collection<QueueItem> queueItem;

	public Collection<QueueItem> getQueueItem() {
		return queueItem;
	}

	public void setQueueItem( final Collection<QueueItem> queueItem ) {
		this.queueItem = queueItem;
	}
}
