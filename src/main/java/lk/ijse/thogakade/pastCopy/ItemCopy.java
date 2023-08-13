package lk.ijse.thogakade.pastCopy;

import lk.ijse.thogakade.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "item")
public class ItemCopy {
    @Id
    @Column(name = "code",length = 30)
    String itemCode;
    @Column(name = "Item_description",nullable = false)
    String ItemDescription;
    @Column(name = "ItemPrice",nullable = false)
    Double price;
    @Column(name = "ItemQty",nullable = false)
    Integer qty;

    @ManyToMany(mappedBy = "items")
    List<Orders> orders = new ArrayList<>();

    /**public Item(String itemCode, String itemDescription, Double price, Integer qty) {
        this.itemCode = itemCode;
        this.ItemDescription = itemDescription;
        this.price = price;
        this.qty = qty;
    }*/
}
