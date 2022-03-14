package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "rows")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Row extends AbsEntity {

    @Column(nullable = false)
    private Integer number;


    @OneToMany(mappedBy = "row", cascade = CascadeType.ALL)
    private List<Seat> seats;

    @ManyToOne
    private Hall hall;

    public Row(Integer number, Hall hall) {
        this.number = number;
        this.hall = hall;
    }
}
