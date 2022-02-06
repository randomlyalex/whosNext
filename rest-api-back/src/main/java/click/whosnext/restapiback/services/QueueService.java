package click.whosnext.restapiback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import click.whosnext.restapiback.domains.Queue;
import click.whosnext.restapiback.domains.QueueItem;
import click.whosnext.restapiback.domains.User;
import click.whosnext.restapiback.repositories.QueueRepository;

@Component
public class QueueService {

	@Autowired
	private QueueRepository queueRepository;
	@Autowired
	private QueueItemService queueItemService;

	public Queue createQueue(final String name) {
		Queue queueToSave = new Queue(name);
		QueueItem sentinelQueueItem = queueItemService.createSentinelItem( queueToSave );
		queueToSave.setHead( sentinelQueueItem );
		queueToSave.setTail( sentinelQueueItem ); // make this a builder
		List<QueueItem> initWaitingList = List.of(sentinelQueueItem);
		queueToSave.setWaitingList( initWaitingList );
		return queueRepository.save(queueToSave);
	}

	public void joinQueue( Queue queue, User user) {}

	public Optional<String> getQueues() {
		return Optional.ofNullable( queueRepository.findAll().toString() );
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
