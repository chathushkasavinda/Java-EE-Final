package lk.ijse.pos.servlet.dao.custom.impl;

import lk.ijse.pos.servlet.dao.custom.ItemDAO;
import lk.ijse.pos.servlet.entity.Item;
import lk.ijse.pos.servlet.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item to) throws SQLException {
        return CrudUtil.setQuery("insert into item values(?,?,?,?)",to.getCode(),to.getName(),to.getQty(),to.getUnitPrice());
    }

    @Override
    public boolean update(Item to) throws SQLException {
        return CrudUtil.setQuery("update item set item_name=?,qty=?,unit_price=? where item_code=?",to.getName(),to.getQty(),to.getUnitPrice(),to.getCode());
    }

    @Override
    public boolean delete(Item to) throws SQLException {
        return CrudUtil.setQuery("delete from item where item_code=?",to.getCode());

    }

    @Override
    public ArrayList<Item> getAll() {
        return null;
    }
}
