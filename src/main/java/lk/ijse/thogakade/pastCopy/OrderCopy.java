package lk.ijse.thogakade.pastCopy;
import lk.ijse.thogakade.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/**
 * this class used to create first relationship
 * now not use class !*/
@Data
@AllArgsConstructor

@Entity
@Table(schema = "orders")
public class OrderCopy {
    @Id
    @Column(name = "orders_id",length = 30)
    String id;

    @CreationTimestamp
    @Column(name = "order_date",nullable = false)
    Date date;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_detail",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "code")
    )
    List<Item> items; // this reference use to mapped attribute !
}
