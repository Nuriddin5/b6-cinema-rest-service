package uz.pdp.b6cinemarestservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "purchase_histories")
public class PurchaseHistory extends AbsEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Ticket ticket;


    // TODO: 3/28/2022
//    private PayType payType;


}
