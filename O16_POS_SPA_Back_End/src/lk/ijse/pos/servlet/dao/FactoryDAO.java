package lk.ijse.pos.servlet.dao;

import lk.ijse.pos.servlet.dao.custom.impl.CustomerDAOImpl;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FactoryDAO {
    private static FactoryDAO factoryDAO;

    private FactoryDAO() {

    }

    public static FactoryDAO getFactoryDAO(){
        if (factoryDAO==null){
            return factoryDAO = new FactoryDAO();
        }else {
            return factoryDAO;
        }
    }

    public SuperDAO getInstance(DAOTypes types){
        switch (types){
            case Customer:
                return new CustomerDAOImpl();

            case Item:
                return null;
            default:
                return null;
        }
    }
}
