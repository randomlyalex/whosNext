package click.whosnext.restapiback.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import click.whosnext.restapiback.domains.Queue;
import click.whosnext.restapiback.domains.QueueItem;
import click.whosnext.restapiback.domains.User;
import click.whosnext.restapiback.repositories.QueueItemRepository;

@Component
public class QueueItemService {

	@Autowired
	private QueueItemRepository queueItemRepository;

	@Autowired
	private UserService userService;

	public QueueItem createSentinelItem( Queue queue) {

		UUID sentinelQueueUuid = UUID.nameUUIDFromBytes(String.format( "sentinal_{}", queue.getName()).getBytes());
		User sentinelUser = userService.getSentinelUser();
		QueueItem sentinelQueueItem = new QueueItem(sentinelQueueUuid , queue, 1, sentinelUser);
		return queueItemRepository.save(sentinelQueueItem);
	}

	public void createQueueItem( User user, Queue queue) {

		Integer position;
		if (queue.isEmpty()) {position = 1;}
		else {position = queue.getTail().getPosition() + 1;}

		QueueItem itemToSave = new QueueItem(queue, position, user);
		queueItemRepository.save( itemToSave );
	}

}
