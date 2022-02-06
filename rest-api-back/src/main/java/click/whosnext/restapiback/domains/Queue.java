package click.whosnext.restapiback.domains;

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
	@Column(name = "list")
	@OneToMany
	private List<QueueItem> list;

	public Queue( final String name ) {
		QueueItem sentinel = new QueueItem(UUID.nameUUIDFromBytes(String.format( "sentinal_{}", name).getBytes()));
		List<QueueItem> initList = List.of(sentinel);
		new Queue(UUID.randomUUID(), name, sentinel, sentinel, initList );
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

	public QueueItem getHead() {
		return head;
	}

	public QueueItem getTail() {
		return this.tail;
	}

	public List<QueueItem> getList() {
		return list;
	}


}
