package uz.pdp.b6cinemarestservice.service.interfaces;

import org.springframework.http.HttpEntity;

public interface MovieSessionService {

    HttpEntity getAllMovieSessions(
            int page,
            int size,
            String search
    );


}
