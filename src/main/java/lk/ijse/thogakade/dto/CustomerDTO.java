package lk.ijse.thogakade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private String name;
    private String address;
    private Double salary;
    private String id;
}
