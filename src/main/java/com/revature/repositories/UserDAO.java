package com.revature.repositories;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;

import java.util.Optional;

import java.util.List;


public class UserDAO implements GenericDAO{
        ConnectionFactory cu = ConnectionFactory.getConnectionFactory();
    /**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */
    public Optional<User> getByUsername(String username) {
        for (User u :)
        return Optional.empty();
    }

    /**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     *
     * Note: The userToBeRegistered will have an id=0, and username and password will not be null.
     * Additional fields may be null.
     */
    public User create(User userToBeRegistered) {
        return userToBeRegistered;
    }

    @Override
    public Object add(Object o) {
        return null;
    }

    @Override
    public Object getById(Integer id) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Integer id) {

    }
}
