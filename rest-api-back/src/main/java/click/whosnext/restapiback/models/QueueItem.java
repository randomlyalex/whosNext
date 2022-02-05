package click.whosnext.restapiback.models;

import java.util.UUID;

public class QueueItem {

	private UUID id;
	private Queue queue;  //queue and position are unique
	private Integer position;
	private User user;

	public QueueItem() {
	}

	public QueueItem(UUID id) {
		this.id = id;
		this.position = 1;
	}

	public QueueItem( final Queue queue, final User user ) {
		new QueueItem(UUID.randomUUID(), queue, queue.getTail().position + 1, user);

	}

	public QueueItem( final UUID id, final Queue queue, final Integer position, final User user ) {
		this.id = id;
		this.queue = queue;
		this.position = position;
		this.user = user;
		queue.addToQueue(this);
	}

	public UUID getId() {
		return id;
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
