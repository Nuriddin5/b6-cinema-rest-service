package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends AbsEntity {

    @Column(nullable = false)
    private String fullName, username, password;

    private String email, phoneNumber;


}
