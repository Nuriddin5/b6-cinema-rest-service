package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.b6cinemarestservice.model.Row;

import java.util.UUID;

public interface RowRepository extends JpaRepository<Row, UUID> {

    Row findByNumber(Integer number);
}
