package com.revature.models;

/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Description</li>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 * public class User extends AbstractUser {
 *
 *     public User(String first_name, String last_name, String email, int phone_number, String address, String username, String password, String role) {
 *         super();
 *     }
 *
 *     //instance variable
 *     private int id;
 *     private String first_name;
 *     private String last_name;
 *     private String email;
 *     private Integer phone_number;
 *     private String address;
 *     private String username;
 *     private String password;
 *     private Enum emp_role;
 *
 *
 */
public class Reimbursement extends AbstractReimbursement {
    private int rbId;
    private Status status;
    private User author;
    private User resolver;
    private double amount;

    public
    Reimbursement() {
        super();
    }

    public
    Reimbursement(int rbId, Status status, User author, User resolver, double amount) {
        super();
        this.rbId = rbId;
        this.status = status;
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
    }

    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractReimbursement} class.
     * If other fields are needed, please create additional constructors.
     */


    public
    int getRbId() {
        return rbId;
    }
    public
    void setRbId(int rbId) {
        this.rbId = rbId;
    }

    public
    Status getStatus() {
        return (Status) status;
    }
    public
    void setStatus(Status status) {
        this.status = status;
    }

    public
    User getAuthor() {
        return author;
    }
    public
    void setAuthor(User Author) {
        this.author = author;
    }

    public
    User getResolver() {
        return resolver;
    }
    public
    void setResolver(User resolver) {
        this.resolver = resolver;
    }

    public
    double getAmount() {
        return amount;
    }
    public
    void setAmount(double Amount) {
        this.amount = amount;
    }




    @Override
    public
    String toString() {
        return "Reimbursement{" +
                "rbId=" + rbId +
                ", status='" + status + '\'' +
                ", author='" + author + '\'' +
                ", resolver='" + resolver + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

}

