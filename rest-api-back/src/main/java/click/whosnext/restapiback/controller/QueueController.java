package click.whosnext.restapiback.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import click.whosnext.restapiback.domains.Queue;
import click.whosnext.restapiback.services.QueueService;

@RestController
public class QueueController {

	@Autowired
	private QueueService queueService;

	@PostMapping("/queue")
	public ResponseEntity<Optional<Queue>> createQueue(
			@RequestParam(name = "name") String name){

		return new ResponseEntity(queueService.createQueue( name ), HttpStatus.OK);
	}

	@GetMapping("/queues")

	public ResponseEntity<Optional<List<Queue>>> getQueues(){
		return new ResponseEntity(queueService.getQueues(), HttpStatus.OK);
	}

	/*
	TODO implement REST routes for the queue here Join etc... then link them up to business login in
	the services etc... Keep this simple the services should do most of the work i think?
	 */
}
