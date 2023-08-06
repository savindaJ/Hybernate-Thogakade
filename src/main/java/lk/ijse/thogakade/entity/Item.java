package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor

@Entity
public class Item {

    @Id
            @Column(name = "Item_ID")
    String id;
    @Column(name = "Item_description")
    String description;
    @Column(name = "Item_unit_price")
    Double unitPrice;
    @Column(name = "Item_qtyOnHand")
    Integer qtyOnHand;
}
