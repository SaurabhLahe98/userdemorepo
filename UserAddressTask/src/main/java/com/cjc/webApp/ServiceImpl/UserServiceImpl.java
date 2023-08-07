package com.cjc.webApp.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cjc.webApp.Entity.User;
import com.cjc.webApp.Exception.UserNotFoundException;
import com.cjc.webApp.Repository.UserRepository;
import com.cjc.webApp.Service.Userservice;

@Service
public class UserServiceImpl implements Userservice{

	@Autowired
	UserRepository ur;
	
	@Override
	public User saveuser(User u) {
	   return ur.save(u);
		
	}

	@Override
	public Iterable<User> getallData(int pageno) {
		
        Sort s = Sort.by("username");
	    
		Pageable p =PageRequest.of(pageno, 2, s);
		
		return ur.findAll(p);
	}

	@Override
	public User updateUserDetails(int userid, User user) {
        
		Optional<User> opUser=ur.findById(userid);
		if(opUser.isPresent()) {
			User updateUser=ur.save(user);
			return updateUser;
		}
		else {
			//throw Exception
		}
		return null;
	}

	@Override
	public void deleteUserDetails(int userid) {
		Optional<User> opUser=ur.findById(userid);
		if(opUser.isPresent()) {
		ur.deleteById(userid);
		}
		else {
			//throw Exception
			System.out.println("USER NOT FOUND IN DATABASE......!!!");
		}
		
	}

	@Override
	public List<User> findUsersByName(String username) throws UserNotFoundException{
		List<User>users = ur.findAllByUsername(username);
		if(users.size()!=0) {
		return users;
		}
		else {
			throw new UserNotFoundException("NO such User In DataBAse with Name "+username);
		}
		
	}

}
