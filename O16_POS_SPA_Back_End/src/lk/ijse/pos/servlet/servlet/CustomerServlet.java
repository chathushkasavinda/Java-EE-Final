package lk.ijse.pos.servlet.servlet;



import lk.ijse.pos.servlet.bo.BOTypes;
import lk.ijse.pos.servlet.bo.FactoryBO;
import lk.ijse.pos.servlet.bo.custom.impl.CustomerBOImpl;
import lk.ijse.pos.servlet.dao.DAOTypes;
import lk.ijse.pos.servlet.dao.FactoryDAO;
import lk.ijse.pos.servlet.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.servlet.dto.CustomerDTO;
import lk.ijse.pos.servlet.util.ResponseUtil;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet(urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

    private final CustomerBOImpl customoerBO = (CustomerBOImpl) FactoryBO.getFactoryBO().getInstance(BOTypes.Customer);

    public CustomerServlet(){
        System.out.println("Customer Servlet Constructor Invoked");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //Initializing connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("select * from Customer");
            ResultSet rst = pstm.executeQuery();
            resp.setContentType("application/json");
            resp.addHeader("Access-Control-Allow-Origin", "*");
            System.out.println("Invoked the do get method");

            JsonArrayBuilder allCustomers = Json.createArrayBuilder();
            while (rst.next()) {
                String id = rst.getString(1);
                String name = rst.getString(2);
                String address = rst.getString(3);
                String salary = rst.getString(4);

                JsonObjectBuilder customerObject = Json.createObjectBuilder();
                customerObject.add("id", id);
                customerObject.add("name", name);
                customerObject.add("address", address);
                customerObject.add("salary", salary);
                allCustomers.add(customerObject.build());
            }
            //create the response Object
            resp.getWriter().print(ResponseUtil.genJson("Success", "Loaded", allCustomers.build()));
        } catch (ClassNotFoundException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.genJson("Error", e.getMessage()));
        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.genJson("Error", e.getMessage()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (customoerBO.addCustomer(new CustomerDTO(req.getParameter("cusID"),req.getParameter("cusName"),req.getParameter("cusAddress"),req.getParameter("cusSalary")))){
                resp.getWriter().print(ResponseUtil.genJson("OK","Successfully Added...!"));
            }else {
                resp.getWriter().print(ResponseUtil.genJson("Error","Not Added"));
            }
        }
            catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.genJson("Error", e.getMessage()));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject jObject = Json.createReader(req.getReader()).readObject();

        try {
            if (customoerBO.updateCustomer(new CustomerDTO(jObject.getString("cusID"),jObject.getString("cusName"),jObject.getString("cusAddress"),jObject.getString("cusSalary")))){
                resp.getWriter().print(ResponseUtil.genJson("OK","SuccessFully Updated"));
            }else {
                resp.getWriter().print(ResponseUtil.genJson("Error","Not updated"));
            }
        }
            catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.genJson("Error", e.getMessage()));
        }


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            if (customoerBO.deleteCustomer(new CustomerDTO(req.getParameter("cusID")))){
                resp.getWriter().print(ResponseUtil.genJson("OK","SuccessFully Deleted"));
            }else {
                resp.getWriter().print(ResponseUtil.genJson("Error","Not Deleted"));
            }
        }
             catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.genJson("Error", e.getMessage()));
        }
    }

}
