package click.whosnext.restapiback.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity (name = "Queue")
@Table(name = "queues")
public class Queue {

	@Id
	@GeneratedValue //TODO: consider hibernate annotations?
	@Column(name = "uuid", unique = true, nullable = false)
	private UUID uuid;

	@Column(name = "name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL) // OneToOne is causing the queue problem because it doesnt have OneToOne Relationship i need to start with a null tail.
	@JoinColumn(name = "head", nullable = false, unique = true)
	private QueueItem head;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tail", unique = true, nullable = true)
	private QueueItem tail;


	@OneToMany(mappedBy = "queue", cascade = CascadeType.ALL)
	private final List<QueueItem> queueItems = new ArrayList<>();

	public Queue( final String name ) {
		this.name = name;
		this.uuid = UUID.randomUUID();
	}

	//	public Queue( final String name ) {
//		QueueItem sentinelQueueItem = new QueueItem(UUID.nameUUIDFromBytes(String.format( "sentinal_{}", name).getBytes()));
//		List<QueueItem> initList = List.of(sentinelQueueItem);
//		new Queue(UUID.randomUUID(), name, sentinelQueueItem, sentinelQueueItem, initList );
//	}


	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public void setName( final String name ) {
		this.name = name;
	}

	public QueueItem getHead() {
		return head;
	}

	public QueueItem getTail() {
		return this.tail;
	}

	public void setUuid( final UUID uuid ) {
		this.uuid = uuid;
	}

	public void setHead( final QueueItem head ) {
		this.head = head;
	}

	public void setTail( final QueueItem tail ) {
		this.tail = tail;
	}

	public List<QueueItem> getQueueItems() {
		return queueItems;
	}

	public void addtoQueueItemsList( final List<QueueItem> queueItems){
		for ( QueueItem queueItem: queueItems) {
			this.addtoQueueItemsList(queueItem);
		}
	}

	public void addtoQueueItemsList( final QueueItem queueItem){
		this.queueItems.add( queueItem );
	}

	public Boolean isEmpty() {
		if (this.tail == null && this.queueItems.size() == 1) {
			return true;
		}
		else {
			System.out.println( "Queue out of sync." );
			//throw QueueSyncException
			return false;
		}
	}

}
