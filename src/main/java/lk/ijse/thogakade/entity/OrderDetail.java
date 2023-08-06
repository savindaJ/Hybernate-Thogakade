package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@AllArgsConstructor

@Entity
public class OrderDetail {

    @Id
    String orderID;
    @Id
    String IemID;

    @Transient
    Integer qty;

}
