/**
 * 
 */
package com.alp.policymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alp.policymanagement.model.User;
import com.alp.policymanagement.repository.UserRepository;

/**
 * @author lenovo
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public String checkLogin(String userId, String password) {
		List<User> users = userRepo.getAllUsers();
		User matchedUser = null;
		return "true";
	}

	public User getUserDetails(String userId) {
		User user = null;
		if (!StringUtils.isEmpty(userId)) {
			user = userRepo.findById(Long.valueOf(userId));
		}
		return user;
	}

	public String addUser(final User user) {
		String userId = userRepo.addUser(user);;
		return userId;
	}
}
