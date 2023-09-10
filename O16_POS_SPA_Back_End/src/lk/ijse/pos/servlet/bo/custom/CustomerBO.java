package lk.ijse.pos.servlet.bo.custom;

import lk.ijse.pos.servlet.bo.SuperBO;
import lk.ijse.pos.servlet.dto.CustomerDTO;

import java.sql.SQLException;

public interface CustomerBO extends SuperBO {
    boolean addCustomer(CustomerDTO dto) throws SQLException;

    boolean updateCustomer(CustomerDTO dto) throws SQLException;

    boolean deleteCustomer(CustomerDTO dto) throws SQLException;

}
