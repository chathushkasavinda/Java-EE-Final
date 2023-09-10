package lk.ijse.pos.servlet.dto;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lk.ijse.pos.servlet.dao.FactoryDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.servlet.annotation.WebFilter;

@Data
@AllArgsConstructor
@ToString
public class CustomerDTO {
    private String id;
    private String name;
    private String address;
    private String salary;
}
