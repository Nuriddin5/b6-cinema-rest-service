package uz.pdp.b6cinemarestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.b6cinemarestservice.payload.ApiResponse;
import uz.pdp.b6cinemarestservice.projection.AvailableSeatsProjection;
import uz.pdp.b6cinemarestservice.repository.SeatRepository;
import uz.pdp.b6cinemarestservice.service.interfaces.SeatService;

import java.util.List;
import java.util.UUID;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepository seatRepository;


    @Override
    public HttpEntity getAvailableSeatsBySessionId(UUID movieSessionId) {
        List<AvailableSeatsProjection> availableSeatsBySessionId = seatRepository.getAvailableSeatsBySessionId(movieSessionId);
        return ResponseEntity.ok(new ApiResponse("success", true, availableSeatsBySessionId));
    }
}
