package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "price_categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceCategory extends AbsEntity {


    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Double vipAddFeeInPercent;

    private String color;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priceCategory")
    private List<Seat> seats;


    public PriceCategory(String name, Double vipAddFeeInPercent, String color) {
        this.name = name;
        this.vipAddFeeInPercent = vipAddFeeInPercent;
        this.color = color;
    }
}
