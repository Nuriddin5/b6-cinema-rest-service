package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "seats")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seat extends AbsEntity {

    @Column(nullable = false)
    private Integer number;

    @ManyToOne
    private Row row;

    @ManyToOne
    private PriceCategory priceCategory;

    public Seat(Integer number, PriceCategory priceCategory) {
        this.number = number;
        this.priceCategory = priceCategory;
    }




}
