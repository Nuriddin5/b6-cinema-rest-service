package uz.pdp.b6cinemarestservice.projection;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public interface CustomMovie {

    UUID getId();

    String getTitle();

    UUID getPosterImgId();

    LocalDate getReleaseDate();


}
