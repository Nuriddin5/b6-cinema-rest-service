package uz.pdp.b6cinemarestservice.projection;

import java.util.UUID;

public interface AvailableSeatsProjection {

    UUID getId();

    Integer getSeatNumber();

    Integer getRowNumber();

    Boolean getAvailable();
}
