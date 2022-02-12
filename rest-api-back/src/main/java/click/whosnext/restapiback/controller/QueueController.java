package click.whosnext.restapiback.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import click.whosnext.restapiback.domains.Queue;
import click.whosnext.restapiback.services.QueueService;

@RestController
public class QueueController {

	@Autowired
	private QueueService queueService;

	@PostMapping("/joinqueue")
	public ResponseEntity<Optional<Queue>> joinQueue(
			@RequestParam(name = "queueUuid") String q,
			@RequestParam(name = "userUuid") String u) {
		UUID queueUuid = UUID.nameUUIDFromBytes(q.getBytes());
		UUID userUuid = UUID.nameUUIDFromBytes(u.getBytes());
		return new ResponseEntity<>(queueService.joinQueue( queueUuid, userUuid), HttpStatus.OK);
	}

	@PostMapping("/queue")
	public ResponseEntity<Queue> createQueue(
			@RequestParam(name = "name") String name){
		return new ResponseEntity<>(queueService.createQueue( name ), HttpStatus.OK);
	}

	@GetMapping("/queues")
	public ResponseEntity<Optional<List<Queue>>> getQueues(){
		return new ResponseEntity<>(queueService.getQueues(), HttpStatus.OK);
	}
}
