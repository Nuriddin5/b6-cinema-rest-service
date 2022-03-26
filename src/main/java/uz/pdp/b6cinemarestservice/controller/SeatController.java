package uz.pdp.b6cinemarestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.b6cinemarestservice.service.interfaces.SeatService;

import java.util.UUID;

@RestController
@RequestMapping("api/seat")
public class SeatController {

    @Autowired
    SeatService seatService;

    @GetMapping("/available-seats/{movieSessionId}")
    public HttpEntity getAvailableSeatsBySessionId(@PathVariable UUID movieSessionId) {
        return seatService.getAvailableSeatsBySessionId(movieSessionId);
    }
}
