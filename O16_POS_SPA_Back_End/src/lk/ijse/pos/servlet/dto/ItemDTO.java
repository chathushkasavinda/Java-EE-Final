package lk.ijse.pos.servlet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class ItemDTO {
    private String code;
    private String name;
    private String qty;
    private String unitPrice;

    public ItemDTO(String code) {

    }
}

