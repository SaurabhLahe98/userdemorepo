package com.cjc.webApp.Service;

import java.util.List;

import com.cjc.webApp.Entity.User;
import com.cjc.webApp.Exception.UserNotFoundException;

public interface Userservice {

public User saveuser(User u);

public Iterable<User> getallData(int pageno);

public User updateUserDetails(int userid, User user);

public void deleteUserDetails(int userid);

public List<User> findUsersByName(String username) throws UserNotFoundException;

}
