package com.revature.models;

import java.sql.Ref;
import java.sql.SQLException;
import java.util.Map;

/**
 * Reimbursements within the ERS application transition through the following statuses:
 * <ul>
 *     <li>Pending</li>
 *     <li>Approved</li>
 *     <li>Denied</li>
 * </ul>
 *
 * Once reimbursements are processed, their final status cannot be changed.
 * A new reimbursement must be submitted.
 *
 * @author Center of Excellence
 */
public enum Status implements Ref {

    PENDING {
        @Override
        public String toString() {
            return "Pending";
        }
    },
    APPROVED {
        @Override
        public String toString() {
            return "Approved";
        }
    },
    DENIED {
        @Override
        public String toString() {
            return "Denied";
        }
    };

    @Override
    public
    String getBaseTypeName() throws SQLException {
        return null;
    }

    @Override
    public
    Object getObject(Map<String, Class<?>> map) throws SQLException {
        return null;
    }

    @Override
    public
    Object getObject() throws SQLException {
        return null;
    }

    @Override
    public
    void setObject(Object value) throws SQLException {

    }
}
