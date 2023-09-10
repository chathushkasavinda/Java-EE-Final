package lk.ijse.pos.servlet.bo.custom;

import lk.ijse.pos.servlet.bo.SuperBO;
import lk.ijse.pos.servlet.dto.ItemDTO;

import java.sql.SQLException;

public interface ItemBO extends SuperBO {
    boolean addItem(ItemDTO dto) throws SQLException;

    boolean updateItem(ItemDTO dto) throws SQLException;

    boolean deleteItem(ItemDTO dto) throws SQLException;

}
