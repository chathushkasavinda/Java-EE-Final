package lk.ijse.pos.servlet.bo.custom.impl;

import lk.ijse.pos.servlet.bo.custom.CustomerBO;
import lk.ijse.pos.servlet.dao.DAOTypes;
import lk.ijse.pos.servlet.dao.FactoryDAO;
import lk.ijse.pos.servlet.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.servlet.dto.CustomerDTO;
import lk.ijse.pos.servlet.entity.Customer;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {
    private final CustomerDAOImpl customerDAO = (CustomerDAOImpl) FactoryDAO.getFactoryDAO().getInstance(DAOTypes.Customer);
    @Override
    public boolean addCustomer(CustomerDTO dto) throws SQLException {
        return customerDAO.add(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException {
        return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary()));
    }

    @Override
    public boolean deleteCustomer(CustomerDTO dto) throws SQLException {
       return customerDAO.delete(new Customer(dto.getId()));
    }
}
