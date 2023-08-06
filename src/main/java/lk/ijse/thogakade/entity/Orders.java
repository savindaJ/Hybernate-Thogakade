package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@AllArgsConstructor

@Entity
@Table(schema = "orders")
public class Orders {

    @Id
    @Column(name = "orders_id",length = 30)
    String id;
    @Column(name = "order_date")
    Date date;
    @Column(name = "customer_ID")
    String customerId;
}
