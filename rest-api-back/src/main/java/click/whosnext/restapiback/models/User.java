package click.whosnext.restapiback.models;

import java.util.UUID;

import com.sun.xml.bind.v2.TODO;

public class User {

	private UUID id;
	private String name;
	private String email;

	public User() {
	}

	public User( final String name, final String email ) {
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail( final String email ) {
		this.email = email;
	}

	public void notify(QueueItem queueItem){
		System.out.println(
				String.format( "Hey {} this would email {} to remind you you're next in queue {}", this.name, this.email,queueItem.getQueue().getName()));
	}

	public void finished(Queue queue){
		// TODO if they're top of the queue then
		queue.whosNext();
		// TODO else leave the queue by removing?

		// TODO maybe have a leave method?
	}

	public void join (){
		// TODO implement join queue method?
	}

	public void finished(QueueItem queueItem){
		this.finished( queueItem.getQueue());
	}

}
