package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@EqualsAndHashCode(callSuper = true)
@Entity(name = "distributors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Distributor extends AbsEntity {
    private String name;

    @Column(columnDefinition = "text")
    private String description;


    @OneToOne
    private Attachment logo;

}
