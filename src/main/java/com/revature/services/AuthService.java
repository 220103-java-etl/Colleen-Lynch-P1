package com.revature.services;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.models.UserBuilder;
import com.revature.repositories.UserDAO;

import java.util.List;
import java.util.Optional;

/**
 * The AuthService should handle login and registration for the ERS application.
 *
 * {@code login} and {@code register} are the minimum methods required; however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Retrieve Currently Logged-in User</li>
 *     <li>Change Password</li>
 *     <li>Logout</li>
 * </ul>
 */
public class AuthService {
    private UserDAO userDAO = new UserDAO();


    /**
     * <ul>
     *     <li>Needs to check for existing users with username/email provided.</li>
     *     <li>Must throw exception if user does not exist.</li>
     *     <li>Must compare password provided and stored password for that user.</li>
     *     <li>Should throw exception if the passwords do not match.</li>
     *     <li>Must return user object if the user logs in successfully.</li>
     * </ul>
     */
    public User login(String username, String password) {
        User u = UserDAO.getByUsername(username);

        if (u != null) {
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return u;
            }
        }else {
            System.out.print("Username and Password do not match");
        }
        return null;
    }
    public List<User> getAll(){
        return userDAO.getAll();
    }



    /**
     * <ul>
     *     <li>Should ensure that the username/email provided is unique.</li>
     *     <li>Must throw exception if the username/email is not unique.</li>
     *     <li>Should persist the user object upon successful registration.</li>
     *     <li>Must throw exception if registration is unsuccessful.</li>
     *     <li>Must return user object if the user registers successfully.</li>
     *     <li>Must throw exception if provided user has a non-zero ID</li>
     * </ul>
     * <p>
     * Note: userToBeRegistered will have an id=0, additional fields may be null.
     * After registration, the id will be a positive integer.
     */
//    public User Register(User userToBeRegistered) {
//        return null;
//    }

    public User register(User u) {
//            int id, String firstName, String lastName, String email, Integer phoneNumber, String address, String userName, String password, Role role){
//        User u = new UserBuilder().setId(id).setFirstName(firstName).setLastName(lastName).setEmail(email).setPhoneNumber(phoneNumber).setAddress(address).setUsername(userName).setPassword(password).setRole(role).createUser();
        u = userDAO.add(u);
        return u;
    }

    /**
     * This is an example method signature for retrieving the currently logged-in user.
     * It leverages the Optional type which is a useful interface to handle the
     * possibility of a user being unavailable.
     */
    public
    Optional<User> exampleRetrieveCurrentUser() {
        return Optional.empty();
    }



}