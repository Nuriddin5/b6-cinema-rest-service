package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.b6cinemarestservice.model.MovieAnnouncement;

import java.util.UUID;

public interface MovieAnnouncementRepository extends JpaRepository<MovieAnnouncement, UUID> {

}
