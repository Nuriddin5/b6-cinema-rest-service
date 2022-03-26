package uz.pdp.b6cinemarestservice.service.interfaces;

import org.springframework.http.HttpEntity;

import java.util.UUID;

public interface SeatService {

    HttpEntity getAvailableSeatsBySessionId(UUID movieSessionId);
}
