package lk.ijse.pos.servlet.bo;

import lk.ijse.pos.servlet.bo.custom.impl.CustomerBOImpl;
import lk.ijse.pos.servlet.bo.custom.impl.ItemBOImpl;
import lk.ijse.pos.servlet.dao.DAOTypes;
import lk.ijse.pos.servlet.dao.FactoryDAO;
import lk.ijse.pos.servlet.dao.SuperDAO;

public class FactoryBO {
    private static FactoryBO factoryBO;

    public FactoryBO() {

    }
    public static FactoryBO getFactoryBO(){
        if (factoryBO==null){
            return factoryBO = new FactoryBO();
        }else {
            return factoryBO;
        }
    }

    public SuperBO getInstance(BOTypes types){
        switch (types){
            case Customer:
                return new CustomerBOImpl();
            case Item:
                return new ItemBOImpl();
            default:
                return null;
        }
    }
}
