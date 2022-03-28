package uz.pdp.b6cinemarestservice.projection;

import java.time.LocalDate;
import java.util.UUID;

public interface TicketProjection {

    UUID getId();

    String getTitle();

    LocalDate getSessionDate();

    // TODO: 3/28/2022  ...
}
