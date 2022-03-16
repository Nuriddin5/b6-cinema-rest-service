package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.b6cinemarestservice.dto.CastDto;
import uz.pdp.b6cinemarestservice.model.Cast;
import uz.pdp.b6cinemarestservice.model.Movie;
import uz.pdp.b6cinemarestservice.projection.CustomMovie;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {



    @Query(value = "select cast(m.id as varchar)            as id,\n" +
            "       m.title,\n" +
            "       m.release_date                   as releaseDate,\n" +
            "       cast(m.poster_img_id as varchar) as posterImgId\n" +
            "\n" +
            "from movies m\n" +
            "where lower(title) like lower(concat('%', :search, '%'))", nativeQuery = true)
    Page<CustomMovie> findAllMoviesPage(Pageable pageable, String search);
}
