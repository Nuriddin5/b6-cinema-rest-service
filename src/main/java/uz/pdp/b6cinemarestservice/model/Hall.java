package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "halls")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hall extends AbsEntity {


    @Column(nullable = false, length = 50)
    private String name;


    private Double vipAddFeeInPercent;

    public Hall(String name) {
        this.name = name;
    }
}
