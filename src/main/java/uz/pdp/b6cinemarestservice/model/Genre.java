package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Entity(name = "genres")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Genre extends AbsEntity {
    private String name;

}
