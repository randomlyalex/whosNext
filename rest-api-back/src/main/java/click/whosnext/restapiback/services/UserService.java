package click.whosnext.restapiback.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import click.whosnext.restapiback.domains.User;
import click.whosnext.restapiback.repositories.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/* other way of injection:
	private final UserRepository userRepository;

	@Autowired
	public UserService( final UserRepository userRepository ) {
		this.userRepository = userRepository;
	} */

	public User getSentinelUser(){
		Optional<User> sentinelUser = userRepository.findById( UUID.nameUUIDFromBytes( "sentinelUser".getBytes() ));
		if (sentinelUser.isPresent()){
			return sentinelUser.get();
		}
		else {
				User user = new User(UUID.nameUUIDFromBytes("sentinelUser".getBytes() ),  "Sentinel User", "Sentinel@User");
				return userRepository.save( user );
		}
	}


	public User addUser(String name, String email){
		User user = new User(name, email);
		System.out.println(user.toString());
		return userRepository.save( user );
	}
	public Optional<User> getUser( UUID uuid){
		return userRepository.findById( uuid );
	}

	public void removeUser(User user){}
	public void updateUser(User user, User userToUpdate){}
	public void notifyUser(User user){}




	/*
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
	 */


}
