package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "item")
public class Item {
    @Id
    @Column(name = "code",length = 30)
    String itemCode;
    @Column(name = "Item_description",nullable = false)
    String ItemDescription;
    @Column(name = "ItemPrice",nullable = false)
    Double price;
    @Column(name = "ItemQty",nullable = false)
    Integer qty;

    @ManyToOne(cascade = CascadeType.ALL)
    Orders orders;

    public Item(String itemCode, String itemDescription, Double price, Integer qty) {
        this.itemCode = itemCode;
        ItemDescription = itemDescription;
        this.price = price;
        this.qty = qty;
    }
}
