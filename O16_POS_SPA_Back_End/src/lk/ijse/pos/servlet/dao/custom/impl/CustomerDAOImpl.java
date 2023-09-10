package lk.ijse.pos.servlet.dao.custom.impl;

import lk.ijse.pos.servlet.dao.custom.CustomerDAO;
import lk.ijse.pos.servlet.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer to) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Customer to) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Customer to) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }
}
