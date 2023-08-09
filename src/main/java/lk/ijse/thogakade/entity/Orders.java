package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

@Entity
@Table(schema = "orders")
public class Orders {

    @Id
    @Column(name = "orders_id",length = 30)
    String id;
    @Column(name = "order_date",nullable = false)
    Date date;

    /*@ManyToMany(cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();*/
    @ManyToOne(cascade = CascadeType.ALL)
    Item item;

}
