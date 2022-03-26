package uz.pdp.b6cinemarestservice.projection;

import java.util.UUID;

//@Projection(types = Row.class)
public interface RowProjection {

    UUID getId();

    Integer getNumber();

    String getHallName();

}
