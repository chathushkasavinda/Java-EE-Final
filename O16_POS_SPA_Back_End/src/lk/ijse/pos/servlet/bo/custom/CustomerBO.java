package lk.ijse.pos.servlet.bo.custom;

import lk.ijse.pos.servlet.bo.SuperBO;
import lk.ijse.pos.servlet.dto.CustomerDTO;

public interface CustomerBO extends SuperBO {
    boolean addCustomer(CustomerDTO dto);
}
