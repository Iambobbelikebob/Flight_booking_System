package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AuthenticationRequest;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtils;
import com.example.demo.service.UserService;



@RestController
public class AuthController {
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	AuthenticationManager authenticates;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	JwtUtils jwtutil;
	
	@PostMapping("/subs")
	private ResponseEntity<AuthenticationResponse>subscribeClient(@RequestBody AuthenticationRequest authreq){
		UserModel usermodel =new UserModel();
		usermodel.setUsername(authreq.getUsername());
		usermodel.setPassword(authreq.getPassword());
		
		
		try {
			userrepo.save(usermodel);
		}
		catch(Exception e){
			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
					("Error during subscription ") , HttpStatus.OK);
		}
		
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
				("Successful subs for client " +authreq.getUsername()), HttpStatus.OK);
}
	
	
	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authreq){
		String username=authreq.getUsername();
		String password= authreq.getPassword();
		try {
			authenticates.authenticate(new UsernamePasswordAuthenticationToken(username, password));
				
		}
		catch(Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse(" Invalid Credentials..!"));
		}
		
		UserDetails userdetails= userservice.loadUserByUsername(username);
		
		String jwt = jwtutil.generateToken(userdetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@GetMapping("/test")
	private String testingtoken() {
		try {
			return "Testing Successful...!";	
		}
		catch(Exception e) {
			return "Please login first..!";
		}
	}
	
	@GetMapping("/dashboard")
	private String dashboard() {
		return "Welcome to dashboard...!";
	}
	

}
