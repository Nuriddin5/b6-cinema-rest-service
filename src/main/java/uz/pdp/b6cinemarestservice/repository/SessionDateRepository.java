package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.b6cinemarestservice.model.SessionDate;

import java.util.UUID;

public interface SessionDateRepository extends JpaRepository<SessionDate, UUID> {
}
