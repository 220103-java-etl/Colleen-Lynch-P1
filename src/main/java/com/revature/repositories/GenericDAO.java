package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.Status;

import java.util.List;

public interface GenericDAO<T> {

    // Create
    T add(T t);

    // Read
    T getById(Integer id);

    List<T> getAll();

    List<Reimbursement> getByStatus(Status status);

    // Update
    void update(T t);

    // Delete
    void delete(Integer id);

}
