package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.b6cinemarestservice.model.Row;
import uz.pdp.b6cinemarestservice.model.Seat;

import java.util.UUID;


public interface SeatRepository extends JpaRepository<Seat, UUID> {

    Seat findByNumber(Integer number);
}
