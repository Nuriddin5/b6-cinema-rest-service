package uz.pdp.b6cinemarestservice.service.interfaces;

import org.springframework.http.HttpEntity;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.b6cinemarestservice.dto.MovieDto;

import java.util.UUID;

public interface MovieService {

    HttpEntity getAllMovies(int size, int page, String search, String sort, boolean direction);

    HttpEntity getMovieById(UUID id);

//    HttpEntity addMovie(MovieDto movieDto);
//
//    HttpEntity editMovie(UUID id, MovieDto movieDto);

    HttpEntity saveMovie(MovieDto movieDto);

    HttpEntity deleteMovieById(UUID id);


}
