package click.whosnext.restapiback.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import click.whosnext.restapiback.domains.User;
import click.whosnext.restapiback.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")  //Depriciate this later
	public ResponseEntity<String> addUser(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email)	{

		User addedUser = userService.addUser( name, email );
		if ( Objects.equals( addedUser.getEmail(), new User( name, email ).getEmail() ) ) {
			return ResponseEntity.status(HttpStatus.OK).body( String.format( "Added %n User: %s %n Email: %s", name, email ) );
		}
		else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body( String.format( "Not Accepted", name, email ));
	}

	@GetMapping("/user")
	public ResponseEntity<String> getUser(){
		return ResponseEntity.status(HttpStatus.OK).body("Test");
	}

}
