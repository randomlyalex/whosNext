package click.whosnext.restapiback.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import click.whosnext.restapiback.domains.Queue;
import click.whosnext.restapiback.domains.QueueItem;
import click.whosnext.restapiback.domains.User;
import click.whosnext.restapiback.repositories.QueueRepository;
import click.whosnext.restapiback.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueueService {

	@Autowired
	private QueueRepository queueRepository;
	@Autowired
	private QueueItemService queueItemService;
	@Autowired
	private UserRepository userRepository;

	public Queue createQueue(final String name) {
		Queue queueToSave = new Queue(name);
		QueueItem sentinelQueueItem = queueItemService.createSentinelItem( queueToSave );
		queueToSave.setHead( sentinelQueueItem );
		queueToSave.addtoQueueItemsList(sentinelQueueItem );
		Queue savedQueue =  queueRepository.save(queueToSave);
		queueItemService.update(sentinelQueueItem, savedQueue);
		return savedQueue;
	}

	public void joinQueue( Queue queue, User user) {


	}

	public Optional<Queue> joinQueue( UUID queueUuid, UUID userUuid) {
		Optional<Queue> queueToJoin = queueRepository.findById( queueUuid );
		Optional<User> userJoining = userRepository.findById( userUuid );
		QueueItem userQueueItem = queueItemService.createQueueItem( userJoining.get(), queueToJoin.get() );
		queueToJoin.get().setTail(userQueueItem);
		queueToJoin.get().addtoQueueItemsList( userQueueItem );
		// save them
		return queueToJoin;
	}

	public Optional<List<Queue>> getQueues() {
		return Optional.of(queueRepository.findAll() );
	}

	public void addToQueue( Queue queue, QueueItem queueItem  ) {

		//TODO also check that its not already in the queue too!
		// TODO check the user isnt in the queue already, this isnt possible either
	}

	public void removeFromQueueByPositon( Queue queue, final Integer position ) {
		//TODO

	}

	public void removeFromQueueByItem( Queue queue, QueueItem queueItem ) {
		//TODO
	}

	public void whosNext(){
		//TODO check the next item etc... then notify with the new head, check for exceptions etc.
	}

}
