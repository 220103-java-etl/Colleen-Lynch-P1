package com.revature.models;

import java.sql.Ref;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 * </ul>
 *
 */
public class User extends AbstractUser {

    //instance variable
//    private int id;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private Integer phoneNumber;
//    private String address;
//    private String username;
//    private String password;
//    private Enum role;

    public
    User() {
        super();
    }

    public
    User(int id, String firstName, String lastName, String email, int phoneNumber, String address, String username, String password, Role role) {
        super(id, firstName, lastName, email, phoneNumber, address, username, password, role);
    }

    public
    User(String firstName, String lastName, String email, Integer phoneNumber, String address, String username, String password, Role role) {
    }
}
//        this.id=id;
//        this.firstName=firstName;
//        this.lastName=lastName;
//        this.email=email;
//        this.phoneNumber=phoneNumber;
//        this.address=address;
//        this.username=username;
//        this.password=password;
//        this.role=role;
//    }


    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractUser} class.
     * If other fields are needed, please create additional constructors.
     */





    //getters and setters

//    @Override
//
//    public int getId() {return id;}
//    public void setId(Integer id){this.id = id;}
//
//    public String getFirstName() {return firstName;}
//    public void setFirstName(String firstName) {this.firstName = firstName;}
//
//    public String getLastName() {return lastName;}
//    public void setLastName(String lastName) {this.lastName = lastName;}
//
//    public String getEmail() {return email;}
//    public void setEmail(String email) {this.email = email;}
//
//    public int getPhoneNumber() {return phoneNumber;}
//    public void setPhoneNumber(Integer phoneNumber) {this.phoneNumber = phoneNumber;}
//
//    public String getAddress() {return address;}
//    public void setAddress(String address) {this.address = address;}
//
//    public String getUsername() {return username;}
//    public void setUsername(String username) {this.username = username;}
//
//    public String getPassword() {return password;}
//    public void setPassword(String password) {this.password = password;}
//
//    public
//    Ref getRole() {return role;}
//    public void setRole(Enum status) {this.role = role;}
//
//@Override
//public String toString() {
//        return "User{" +
//            "id=" +id +
//            "firstName='" + firstName + '\'' +
//            ", lastName='" + lastName + '\'' +
//            ", email='" + email + '\'' +
//            ", phoneNumber='" + phoneNumber + '\'' +
//            ", address='" + address + '\'' +
//            ", username='" + username + '\'' +
//            ", password='" + password + '\'' +
//            ", role='" + role + '\'' +
//            '}';
//}
//
//
//    }


