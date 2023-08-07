package com.cjc.webApp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.webApp.Entity.BaseResponse;
import com.cjc.webApp.Entity.User;
import com.cjc.webApp.Exception.UserNotFoundException;
import com.cjc.webApp.Service.Userservice;


@RestController
@CrossOrigin("*")
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	Userservice us;
	
	
	@PostMapping("/create_user")
	public ResponseEntity<BaseResponse<User>> saveUser(@RequestBody User u) {
	User saveuser=us.saveuser(u);
		return new ResponseEntity<BaseResponse<User>>(
				new BaseResponse<User>(201,"USER CREATED",new Date(),saveuser),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/view-user/{pageno}")
	public Iterable<User> getAllData(@PathVariable int pageno) {
		 Iterable<User>li=us.getallData(pageno);
		 return li;
	}
	
	@PutMapping("/user/{userid}")
	public User updateUser(@PathVariable int userid,@RequestBody User user) {
		User u = us.updateUserDetails(userid,user);
		return u;
		
	}
	
	@DeleteMapping("/user/{userid}")
	public void RemoveUser(@PathVariable int userid) {
	
	    us.deleteUserDetails(userid); 	
	}
	
	
	//For SEARCH BAR
	
	@GetMapping("user/{username}")
	public ResponseEntity<BaseResponse<List<User>>> findUsers(@PathVariable String username) throws UserNotFoundException{
		
		List<User> searchUsers=us.findUsersByName(username);
		return new ResponseEntity<BaseResponse<List<User>>>(new BaseResponse<List<User>>(200,"SEARCH RESULT" , new Date(),searchUsers),HttpStatus.OK);
		
	}
	//cooment
	 
}
