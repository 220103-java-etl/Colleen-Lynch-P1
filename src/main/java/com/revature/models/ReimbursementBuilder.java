package com.revature.models;

public
class ReimbursementBuilder {
    private int rb_id;
    private Status status;
    private User author;
    private User resolver;
    private double amount;
    private int rbId;

    public
    ReimbursementBuilder setRb_id(int rb_id) {
        this.rb_id = rb_id;
        return this;
    }

    public
    ReimbursementBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public
    ReimbursementBuilder setAuthor(User author) {
        this.author = author;
        return this;
    }

    public
    ReimbursementBuilder setResolver(User resolver) {
        this.resolver = resolver;
        return this;
    }

    public
    ReimbursementBuilder setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public
    ReimbursementBuilder setRbId(int rbId) {
        this.rbId = rbId;
        return this;
    }

    public
    Reimbursement createReimbursement() {
        return new Reimbursement(rb_id, status, author, resolver, amount);
    }
}