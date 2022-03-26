package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.b6cinemarestservice.model.Movie;
import uz.pdp.b6cinemarestservice.projection.CustomMovie;
import uz.pdp.b6cinemarestservice.projection.CustomMovieById;

import java.util.Optional;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {


    @Query(value = "select\n" +
            "       cast(m.id as varchar) as id,\n" +
            "       title,\n" +
            "       cast(release_date as date)as releaseDate,\n" +
            "       cast(a.id as varchar) as coverImgId\n" +
            "from movies m\n" +
            "join attachments a on a.id = m.cover_img_id\n" +
            "where lower(title) like lower(concat('%', :search, '%'))", nativeQuery = true)
    Page<CustomMovie> findAllMoviesPage(Pageable pageable, @Param("search") String search);


    @Query(nativeQuery = true, value = "select" +
            " cast(m.id as varchar)            as id,\n" +
            "       m.title,\n" +
            "       m.release_date                   as releaseDate,\n" +
            "       cast(m.cover_img_id as varchar) as coverImgId\n" +
            //todo add more columns
            "from movies m " +
            "where m.id = :id")
    Optional<CustomMovieById> getMovieById(UUID id);
}
