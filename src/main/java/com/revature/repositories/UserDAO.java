package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;


public class UserDAO implements GenericDAO<User> {
    static ConnectionFactory cf = ConnectionFactory.getConnectionFactory();



    /**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */

 /**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     * <p>
     * Note: The userToBeRegistered will have an id=0, and username and password will not be null.
     * Additional fields may be null.
     */



    @Override
    public User add(User user) {
        String sql = "insert into users values (default, ?, ?, ?, ?, ?, ?, ?, ?) returning *";
        try (Connection conn = cf.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getPhoneNumber());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getUsername());
            ps.setString(7, user.getPassword());
            ps.setRef(8, user.getRole());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public
    User getById(Integer id) {
        return null;
    }

    @Override
    public User getById(int id) {
        String sql = "select * from users where emp_id = ?";

        try (Connection conn = cf.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User(
                        rs.getInt("emp_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getInt("phone_number"),
                        rs.getString("address"),
                        rs.getString("username"),
                        rs.getString("password"),
                        (Role) rs.getRef("role")
                );
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        public static
        User getByUsername(String username) {
            String sql = "select * from users where username = ?";
            try (Connection conn = cf.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    User u = new User(
                            rs.getInt("emp_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getInt("phone_number"),
                            rs.getString("address"),
                            rs.getString("username"),
                            rs.getString("password"),
                            (Role) rs.getRef("role")
                    );
                    return u;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
    String sql = "select * from users";
    try(Connection conn = cf.getConnection()){
        PreparedStatement ps =conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User u = new User(
                    rs.getInt("emp_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getInt("phone_number"),
                    rs.getString("address"),
                    rs.getString("username"),
                    rs.getString("password"),
                    (Role) rs.getRef("role")
            );
            users.add(u);
        }

        return users;
    } catch(SQLException e) {
        e.printStackTrace();
    }
    return null;
}


    @Override
    public List<Reimbursement> getByStatus(Status status) {
        return null;}

    @Override
    public void update(User user) {
String sql = "update users set first_name = ?, last_name = ?, email = ?, phone_number ?, address = ?,  username = ?, password = ?, role = ?";
    try(Connection conn = cf.getConnection()){
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getEmail());
        ps.setInt(4, user.getPhoneNumber());
        ps.setString(5, user.getAddress());
        ps.setString(6, user.getUsername());
        ps.setString(7, user.getPassword());
        ps.setRef(8, (Ref)user.getRole());

        ps.executeUpdate();
    }catch (SQLException e) {
        e.printStackTrace();
    }
    }


    @Override
    public void delete(Integer id) {
        String sql = "delete from users where emp_id = ?";
        try(Connection conn = cf.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private String lastName;

    public
    User getByLastName(String lastName) {
        String sql = "select * from users where lastName = ?";
        try (Connection conn = cf.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, lastName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getInt("emp_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getInt("phone_number"),
                        rs.getString("address"),
                        rs.getString("username"),
                        rs.getString("password"),
                        (Role) rs.getRef("role")
                );
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<User> users;

}
