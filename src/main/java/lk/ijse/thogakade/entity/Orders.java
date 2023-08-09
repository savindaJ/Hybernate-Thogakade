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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
            @JoinTable(
                    name = "order_detail",
                    joinColumns = @JoinColumn(name = "orders_id"),
                    inverseJoinColumns = @JoinColumn(name = "code")
            )
    List<Item> items;

}
