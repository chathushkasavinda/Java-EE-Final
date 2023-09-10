package lk.ijse.pos.servlet.dao.custom.impl;

import lk.ijse.pos.servlet.dao.DAOTypes;
import lk.ijse.pos.servlet.dao.FactoryDAO;
import lk.ijse.pos.servlet.dao.custom.CustomerDAO;
import lk.ijse.pos.servlet.entity.Customer;
import lk.ijse.pos.servlet.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer to) throws SQLException {
       return CrudUtil.setQuery("insert into Customer values(?,?,?,?)",to.getId(),to.getName(),to.getAddress(),to.getSalary());
    }

    @Override
    public boolean update(Customer to) throws SQLException {
        return CrudUtil.setQuery("update Customer set name=?,address=?,salary=? where id=?",to.getName(),to.getAddress(),to.getSalary(),to.getId());
    }

    @Override
    public boolean delete(Customer to) throws SQLException {
        return CrudUtil.setQuery("delete from Customer where id=?",to.getId());
    }

    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }
}
