package lk.ijse.thogakade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class OrderDTO {
    private int id;
    private String description;
    private Timestamp orderDateTime;
}
