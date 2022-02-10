package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReimbursementDAO implements GenericDAO<Reimbursement> {
    ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
    private Reimbursement reimbursement;


    @Override
    public Reimbursement add(Reimbursement reimbursement) {
        String sql = "insert into reimbursement values (default, ?, ?, ?, ?) returning *";
        try (Connection conn = cf.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbursement.getRbId());
            ps.setRef(2, (Ref) reimbursement.getStatus());
            ps.setObject(3, reimbursement.getAuthor());
            ps.setObject(4, reimbursement.getResolver());
            ps.setDouble(5, reimbursement.getAmount());


            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reimbursement r = new Reimbursement(
                        rs.getInt("rb_id"),
                        (Status) rs.getRef("status"),
                        (User) rs.getObject("author"),
                        (User) rs.getObject("resolver"),
                        rs.getDouble("amount")
                );
                return r;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Reimbursement getById(Integer rbId) {
        String sql = "select * from rb_status where rb_id = ?";
        try (Connection conn = cf.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rbId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Reimbursement r = new Reimbursement(
                        rs.getInt("rb_id"),
                        (Status) rs.getRef("status"),
                        (User) rs.getObject("author"),
                        (User) rs.getObject("resolver"),
                        rs.getDouble("amount")
                );
                return r;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public
    User getById(int id) {
        return null;
    }

    @Override
    public List<Reimbursement> getAll() {
        return null;
    }

    @Override

    public List<Reimbursement> getByStatus(Status status) {
        List<Reimbursement> reimbursements = new ArrayList<>();
        String sql = "select * from rb_status";
        try (Connection conn = cf.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reimbursement r = new Reimbursement(
                        rs.getInt("rb_id"),
                        (Status) rs.getRef("status"),
                        (User) rs.getObject("author"),
                        (User) rs.getObject("resolver"),
                        rs.getDouble("amount")

                );
                reimbursements.add(r);
            }
            return reimbursements;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void update(Reimbursement unprocessedReimbursement) {
        String sql = "update rb_status set rb_id = ?, status = ?, author = ? resolver = ?, amount = ?";
        try (Connection conn = cf.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbursement.getRbId());
            ps.setRef(2, reimbursement.getStatus());
            ps.setObject(3, reimbursement.getAuthor());
            ps.setObject(3, reimbursement.getResolver());
            ps.setDouble(3, reimbursement.getAmount());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer rbId) {
        String sql = "delete from rb_status where rb_id = ?";

        try (Connection conn = cf.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rbId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}












//
//        /**
//     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
//     */
//    public Optional<Reimbursement> getById(int id) {
//        return Optional.empty();
//    }
//
//    /**
//     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
//     */
//    public List<Reimbursement> getByStatus(Status status) {
//        return Collections.emptyList();
//    }
//
//    /**
//     * <ul>
//     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
//     *     <li>Should throw an exception if the update is unsuccessful.</li>
//     *     <li>Should return a Reimbursement object with updated information.</li>
//     * </ul>
//     */
//    public Reimbursement update(Reimbursement unprocessedReimbursement) {
//    	return null;
//    }
//}
