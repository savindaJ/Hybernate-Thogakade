package lk.ijse.thogakade.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemTM {
    private Integer itemCode;
    private String name;
    private Double price;
    private Integer qty;
}
