package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.Entity;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "session_times")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionTime extends AbsEntity {

    private LocalTime time;

    private Double sessionAddFeeInPercent;


    public SessionTime(LocalTime time) {
        this.time = time;
    }
}
