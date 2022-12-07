package com.example.demo.controller;

import java.util.List ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.user;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.UserRepo;

@RestController // to create rest API
@RequestMapping("/api/users")
public class usercontroller {

	@Autowired 
	private UserRepo UserRepo ;
	
	// get all users 
	
	@GetMapping
	public List<user> getAlluser(){
		return this.UserRepo.findAll() ;

	}
	
	// get user by id 
	
	@GetMapping("/{id}")
	public user getuserbyid(@PathVariable (value = "id") long userId) {
		return this.UserRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("user not found with id :" + userId)) ; 
		// lamda expression if user not found we throw a exception
	}
	
	//create user
	@PostMapping
	public user createUser(@RequestBody user user) {
		return this.UserRepo.save(user) ;	
	}
	
	
	// update user
	
	@PutMapping("/{id}")
	public user updateUser(@RequestBody user user, @PathVariable ("id") long userId) {
		user existing =  this.UserRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("user not found with id :" + userId)) ; 
		existing.setFirrstName(user.getFirrstName()); 
		existing.setLastName(user.getLastName()) ;
		existing.setEmail(user.getEmail()) ;
		return this.UserRepo.save(existing) ;
	}
	
	
	// delete user by id 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<user> deleteUser(@PathVariable ("id") long userId){
		
		user existing =  this.UserRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("user not found with id :" + userId)) ; 
		this.UserRepo.delete(existing) ;
		return ResponseEntity.ok().build() ;
	}
}
