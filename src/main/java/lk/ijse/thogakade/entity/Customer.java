package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*identify entity*/
@Entity
/*naming table*/
@Table(schema = "customer")
public class Customer {
    @Column(name = "CustomerName",nullable = false)
    String name;
    @Column(name = "CustomerAddress",nullable = false)
    String address;
    @Column(name = "CustomerSalary",nullable = false)
    Double salary;
    @Id //identify primary key
    @Column(name = "customerID",length = 30)  // identify column
    String id;
    /*
        *  embedded usage
        *  new NameIdentifier
        *  set setters and set object in object !
    */
   /* private NameIdentifier nameIdentifier;*/

   /* @ElementCollection
            @CollectionTable(
                    name = "numbers",
                    joinColumns = @JoinColumn(name = "customerID")
            )
    List<MobileNo> mobileNos = new ArrayList<>();*/

   /* Customer customer = new Customer();

    void sample(){
        MobileNo mobileNo = new MobileNo();
        mobileNo.setMobileLine("022144555555");
        customer.setMobileNos(mobileNo);
    }*/

                      /*generative type*/
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE)*/
    /*@GeneratedValue(strategy = GenerationType.TABLE)*/

    /*https://stackoverflow.com/questions/67511979/jpa-how-can-an-entity-refer-to-two-other-entities-involved-in-a-manytomany-rel*/

    /*https://howtodoinjava.com/hibernate/hibernate-one-to-many-mapping/*/
}
