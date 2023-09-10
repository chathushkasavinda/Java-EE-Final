package lk.ijse.pos.servlet.util;

import lk.ijse.pos.servlet.dao.SuperDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SQLUtil<T> extends SuperDAO {
    boolean add(T to) throws SQLException;
    boolean update(T to) throws SQLException;
    boolean delete(T to) throws SQLException;
    ArrayList<T> getAll();

}
