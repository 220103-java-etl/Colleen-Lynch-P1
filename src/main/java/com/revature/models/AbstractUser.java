package com.revature.models;

import java.sql.Ref;
import java.util.Objects;

/**
 * This AbstractUser class defines a minimum functionality for
 * interacting with users in the ERS application.
 *
 * All users in this application must at least have:
 * <ul>
 *     <li>ID</li>
 *     <li>Username</li>
 *     <li>Password</li>
 *     <li>Role</li>
 * </ul>
 *
 * Additional fields can be added to the concrete {@link com.revature.models.User} class.
 *
 * @author Center of Excellence
 */

public class AbstractUser {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String address;
    private String username;
    private String password;
    private Role role;

    public AbstractUser(){
        super();
    }


    public AbstractUser(int id, String firstName, String lastName, String email, Integer phoneNumber, String address, String username, String password, Role role) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName= lastName;
        this.email= email;
        this.phoneNumber= phoneNumber;
        this.address= address;
        this.username = username;
        this.password = password;
        this.role = role;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {return email;}
    public void setEmail(String email) {
        this.email = email;
    }
    public int getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {return address;}
    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public
    Ref getRole() {
        return (Ref) role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractUser that = (AbstractUser) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)
                && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(address, that.address) && Objects.equals(password, that.password) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, address, username, password, role);
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName'" + lastName + '\'' +
                ", email'" + email + '\'' +
                ", phoneNumber'" + phoneNumber + '\'' +
                ", address'" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }


}
