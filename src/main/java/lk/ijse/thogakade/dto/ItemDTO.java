package lk.ijse.thogakade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTO {

   private String itemCode;
   private String description;
   private Double price;
   private Integer qty;
}
