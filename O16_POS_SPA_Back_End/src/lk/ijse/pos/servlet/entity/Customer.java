package lk.ijse.pos.servlet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Customer {
    private String id;
    private String name;
    private String address;
    private String salary;

    public Customer(String id) {

    }
}
