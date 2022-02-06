package click.whosnext.restapiback.domains;

import static javax.persistence.CascadeType.ALL;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "Queue")
@Table(name = "queues")
public class Queue {

	@Id
	@Column(name = "uuid")
	private UUID uuid = UUID.randomUUID();

	@Column(name = "name", nullable = false)
	private String name;

	@OneToOne(optional = false)
	@JoinColumn(name = "head", nullable = false, unique = true)
	private QueueItem head;

	@OneToOne(optional = false)
	@JoinColumn(name = "tail", nullable = false, unique = true)
	private QueueItem tail;

	@Column(name = "queue_item")
	@OneToMany(cascade=ALL, mappedBy="user")
	private List<QueueItem> waitingList;

	public Queue( final String name ) {
		this.name = name;
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

	public List<QueueItem> getwaitingList() {
		return waitingList;
	}

	public void setHead( final QueueItem head ) {
		this.head = head;
	}

	public void setTail( final QueueItem tail ) {
		this.tail = tail;
	}

	public List<QueueItem> getWaitingList() {
		return waitingList;
	}

	public void setWaitingList( final List<QueueItem> waitingList ) {
		this.waitingList = waitingList;
	}

//	public String toString(){
//		return String.format( "Queue Name: %s %n Queue Size: %s", this.name, this.waitingList.size() -1 );
//	}

	public Boolean isEmpty() {
		if (this.head == this.tail && this.waitingList.size() == 1) {
			return true;
		}
		else {
			System.out.println( "Queue out of sync." );
			//throw QueueSyncException
			return false;
		}
	}

}
