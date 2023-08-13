package lk.ijse.thogakade.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Embeddable
public class OrderDetailPK implements Serializable {

    @Column(name = "order_id")
    private int orderId;
    @Column(name = "item_id")
    private int itemId;


    public OrderDetailPK() {

    }
}
