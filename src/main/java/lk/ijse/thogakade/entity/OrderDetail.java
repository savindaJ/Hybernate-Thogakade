package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor

@Entity
@Table(schema = "Order_detail")
public class OrderDetail {
    @Id
    @Column(name = "order_ID",length = 30)
    String orderId;
    @Column(name = "item_code",length = 30)
    String itemCode;
    @Column(name = "qty",nullable = false)
    Integer qty;
}
