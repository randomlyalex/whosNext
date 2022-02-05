package click.whosnext.restapiback.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


public class Queue {

	private UUID id;
	private String name;
	private QueueItem head;
	private QueueItem tail;
	private List<QueueItem> list;

	public Queue() {
	}

	public Queue( final String name ) {
		QueueItem sentinel = new QueueItem(UUID.nameUUIDFromBytes(String.format( "sentinal_{}", name).getBytes()));
		List<QueueItem> initList = new ArrayList<>();
		new Queue(UUID.randomUUID(), name, sentinel, sentinel, initList );
	}

	public Queue( final UUID id, final String name, final QueueItem head, final QueueItem tail,
			final List<QueueItem> list ) {
		this.id = id;
		this.name = name;
		this.head = head;
		this.tail = tail;
		this.list = list;
	}

	public UUID getId() {
		return id;
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

	public Boolean isEmpty() {
		if (this.head == this.tail && this.list.size() == 1) {
			return true;
		}
		else {
			System.out.println( "Queue out of sync." );
			//throw QueueSyncException
			return false;
		}
	}

	public void addToQueue( final QueueItem queueItem ) {
		this.tail = queueItem;
		this.list.add(queueItem);
		if (  list.size() != queueItem.getPosition() ){
			System.out.println( "Queue out of sync." );
			//throw QueueSyncException
		}
		//TODO also check that its not already in the queue too!
		// TODO check the user isnt in the queue already, this isnt possible either
	}

	public QueueItem removeFromQueueByPositon( final Integer position ) {
		try {
			if ( position == 1 ) {
				throw new IndexOutOfBoundsException();
			}

			QueueItem itemToRemove = list.get( position );
			this.removeFromQueueByItem( itemToRemove );

			if ( list.size() != this.tail.getPosition() ) {

				System.out.println( "Queue out of sync." );
				//throw QueueSyncException
			}

			return itemToRemove;
		}
		catch ( IndexOutOfBoundsException e ) {
			System.out.println( "Position Invalid" );
			//throw PositionInvalidException
			return null;
		}
	}

	public Boolean removeFromQueueByItem( final QueueItem queueItem ) {
		try {
			this.list.remove(queueItem);
		}
		catch (Exception e) {
			System.out.println( "Error removing from the list in queue" );
			//throw ListRemoveError
			return false;
		}
		if (  list.size() != this.tail.getPosition() ){
			System.out.println( "Queue out of sync." );
			//throw QueueSyncException
			return false;
		}
		else return true ;
	}

	public void whosNext(){
		this.removeFromQueueByItem( this.head );
		//TODO check the next item etc... then notify with the new head, check for exceptions etc.
		this.head.getUser().notify(this.head);
	}
}
