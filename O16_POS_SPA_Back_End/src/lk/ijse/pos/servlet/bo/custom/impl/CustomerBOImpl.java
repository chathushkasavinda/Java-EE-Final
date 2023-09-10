package lk.ijse.pos.servlet.bo.custom.impl;

import lk.ijse.pos.servlet.bo.custom.CustomerBO;
import lk.ijse.pos.servlet.dao.FactoryDAO;
import lk.ijse.pos.servlet.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.servlet.dto.CustomerDTO;

public class CustomerBOImpl implements CustomerBO {

    @Override
    public boolean addCustomer(CustomerDTO dto) {
        return false;
    }
}
