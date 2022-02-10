package com.revature.models;

public
class UserBuilder {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String address;
    private String username;
    private String password;
    private Role role;
    private Integer phoneNumber0;
    private int emp_id;
    private String first_name;
    private String last_name;
    private int phone_number;

    public
    UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public
    UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public
    UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public
    UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public
    UserBuilder setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public
    UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public
    UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public
    UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public
    UserBuilder setRole(Role role) {
        this.role = role;
        return this;
    }

    public
    UserBuilder setPhoneNumber0(Integer phoneNumber0) {
        this.phoneNumber0 = phoneNumber0;
        return this;
    }

    public
    UserBuilder setEmp_id(int emp_id) {
        this.emp_id = emp_id;
        return this;
    }

    public
    UserBuilder setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public
    UserBuilder setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public
    UserBuilder setPhone_number(int phone_number) {
        this.phone_number = phone_number;
        return this;
    }

    public
    User createUser() {
        return new User(id, firstName, lastName, email, phoneNumber, address, username, password, role);
    }
}