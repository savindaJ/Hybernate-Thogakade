package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@AllArgsConstructor

@Entity
public class Orders {

    @Id
            @Column(name = "order_ID")
    String id;
    @Column(name = "Order_date")
    Date date;
    @Column(name = "customer_ID")
    String customerId;
}
