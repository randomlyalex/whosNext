package click.whosnext.restapiback.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	@ResponseBody
	public Optional<String> createQueue(
			@RequestParam(name = "name") String name){
		Queue queue = queueService.createQueue( name );
		return Optional.ofNullable( queue.toString() );
	}

	@GetMapping("/queues")
	@ResponseBody
	public Optional<String> getQueues(){
		return queueService.getQueues();
	}

	/*
	TODO implement REST routes for the queue here Join etc... then link them up to business login in
	the services etc... Keep this simple the services should do most of the work i think?
	 */
}
