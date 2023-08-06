package lk.ijse.thogakade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class OrderDTO {
    private String id;
    private Date date;
    private String customerId;

}
