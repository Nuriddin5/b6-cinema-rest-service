package uz.pdp.b6cinemarestservice.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.pdp.b6cinemarestservice.model.Genre;
import uz.pdp.b6cinemarestservice.model.Movie;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Projection(types = Movie.class)
public interface CustomMovieById {

    UUID getId();

    String getTitle();

    UUID getCoverImgId();

    LocalDate getReleaseDate();


    // todo get more fields

    @Value("#{@genreRepository.getGenreByMovieId(target.id)}")
    List<GenreProjection> getGenres();


}
