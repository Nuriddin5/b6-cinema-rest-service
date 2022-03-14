package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.b6cinemarestservice.dto.CastDto;
import uz.pdp.b6cinemarestservice.model.Cast;
import uz.pdp.b6cinemarestservice.model.Movie;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {


}
