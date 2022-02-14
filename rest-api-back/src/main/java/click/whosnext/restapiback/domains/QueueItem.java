package click.whosnext.restapiback.domains;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity (name = "QueueItem")
@Table(name = "queue_items")
public class QueueItem {

	@Id
	@Column(name = "uuid", unique = true, nullable = false)
	private UUID uuid;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="queue_id")
	private Queue queue;  //queue and position are unique

	@Column(name = "position")
	private Integer position;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;

	public QueueItem( Queue queue, Integer position, User user ) {
		this.uuid = UUID.randomUUID();
		this.queue = queue;
		this.position = position;
		this.user = user;
	}

	public void setUuid( final UUID uuid ) {
		this.uuid = uuid;
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
