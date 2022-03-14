package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.b6cinemarestservice.model.Hall;

import java.util.UUID;

public interface HallRepository extends JpaRepository<Hall, UUID> {

    Hall findByName(String name);
}
