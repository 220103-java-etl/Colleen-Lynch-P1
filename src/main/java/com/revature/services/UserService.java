package com.revature.services;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

import java.util.List;
import java.util.Optional;

/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class UserService {


	private UserDAO userDAO = new UserDAO();

	public User login(String username, String password) {
		User u = UserDAO.getByUsername(username);

		if (u != null) {
//			System.out.println(u.getUsername());
//			System.out.println(u.getPassword());
			if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
				return u;
			}
		}
		System.out.println("Credentials do not match");
		return null;
	}
	public User Register(int id, String firstName, String lastName, String email, int phoneNumber, String address, String username,String password, String role){
		User U = new User(id, firstName,lastName,email, phoneNumber, address, username,password, Role.valueOf(role));
		U = userDAO.add(U);
		return U;
	}
	/**
	 * Should retrieve a User with the corresponding username or an empty optional if there is no match.
	 */

	public List<User> getAll(){
		return userDAO.getAll();
	}
	public User getById(int id) {
		return userDAO.getById(id);
	}

	public
	User addUser(User u) {
		return u;
	}


	public
	Optional<User> getByUsername(String username) {
		return Optional.empty();
	}


//    public
//    User addUser(User u) {
//		return u;
//	}

}

