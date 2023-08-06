package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "item")
public class Item {
    @Id
    @Column(name = "code",length = 30)
    String itemCode;
    @Column(name = "ItemName")
    String name;
    @Column(name = "ItemPrice")
    Double price;
    @Column(name = "ItemQty")
    Integer qty;
}
