package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor

@Entity
public class Customer {
    @Id
            @Column(name = "customer_ID")
    String id;
    @Column(name = "customer_name")
    String name;
    @Column(name = "customer_address")
    String address;
    @Column(name = "customer_salary")
    Double salary;
}
