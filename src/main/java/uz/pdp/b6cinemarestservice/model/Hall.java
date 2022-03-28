package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "halls")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hall extends AbsEntity {


    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private List<Row> rows;

    private Double vipAddFeeInPercent;

    public Hall(String name) {
        this.name = name;
    }

    public Hall(String name, Double vipAddFeeInPercent) {
        this.name = name;
        this.vipAddFeeInPercent = vipAddFeeInPercent;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "name='" + name + '\'' +
                ", vipAddFeeInPercent=" + vipAddFeeInPercent +
                '}';
    }
}
