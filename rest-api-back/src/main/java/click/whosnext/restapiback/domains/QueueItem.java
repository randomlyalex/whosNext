package click.whosnext.restapiback.domains;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "QueueItem")
@Table(name = "queue_items")
public class QueueItem {

	@Id
	@Column(name = "uuid")
	private UUID uuid = UUID.randomUUID();
	@Column(name = "queue")
	@ManyToOne
	private Queue queue;  //queue and position are unique
	@Column(name = "position", nullable = false)
	private Integer position;
	@Column(name = "user")
	@ManyToOne
	private User user;

	public QueueItem( UUID givenId) {
		this.uuid = givenId;
		this.position = 1;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Queue getQueue() {
		return queue;
	}

	public void setQueue( final Queue queue ) {
		this.queue = queue;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition( final Integer position ) {
		this.position = position;
	}

	public User getUser() {
		return user;
	}

	public void setUser( final User user ) {
		this.user = user;
	}
}
