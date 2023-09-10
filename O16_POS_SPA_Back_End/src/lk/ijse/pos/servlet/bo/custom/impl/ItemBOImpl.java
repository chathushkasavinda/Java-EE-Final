package lk.ijse.pos.servlet.bo.custom.impl;

import lk.ijse.pos.servlet.bo.custom.ItemBO;
import lk.ijse.pos.servlet.dao.DAOTypes;
import lk.ijse.pos.servlet.dao.FactoryDAO;
import lk.ijse.pos.servlet.dao.custom.ItemDAO;
import lk.ijse.pos.servlet.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.servlet.dto.ItemDTO;
import lk.ijse.pos.servlet.entity.Item;

import java.sql.SQLException;

public class ItemBOImpl implements ItemBO {
    private final ItemDAOImpl itemDAO=(ItemDAOImpl) FactoryDAO.getFactoryDAO().getInstance(DAOTypes.Item);
    @Override
    public boolean addItem(ItemDTO dto) throws SQLException {
        return itemDAO.add(new Item(dto.getCode(),dto.getName(),dto.getQty(),dto.getUnitPrice()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException {
        return itemDAO.update(new Item(dto.getCode(),dto.getName(),dto.getQty(),dto.getUnitPrice()));

    }

    @Override
    public boolean deleteItem(ItemDTO dto) throws SQLException {
        return itemDAO.delete(new Item(dto.getCode()));

    }
}
