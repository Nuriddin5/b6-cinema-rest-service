package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.enums.RoleEnum;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role extends AbsEntity {

//    private RoleEnum roleEnum;

    @Column(unique = true)
    private String name;


}
