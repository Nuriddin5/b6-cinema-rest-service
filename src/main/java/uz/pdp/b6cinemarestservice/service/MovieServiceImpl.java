package uz.pdp.b6cinemarestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import uz.pdp.b6cinemarestservice.dto.MovieDto;
import uz.pdp.b6cinemarestservice.model.Movie;
import uz.pdp.b6cinemarestservice.payload.ApiResponse;
import uz.pdp.b6cinemarestservice.projection.CustomMovie;
import uz.pdp.b6cinemarestservice.projection.CustomMovieById;
import uz.pdp.b6cinemarestservice.repository.MovieRepository;
import uz.pdp.b6cinemarestservice.service.interfaces.MovieService;

import java.util.Optional;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;


    @Override
    public HttpEntity getAllMovies(int size, int page, String search, String sort, boolean direction) {

        try {
            Pageable pageable = PageRequest.of(
                    page - 1,
                    size,
                    direction ? Sort.Direction.ASC : Sort.Direction.DESC,
                    sort
            );
            Page<CustomMovie> all = movieRepository.findAllMoviesPage(pageable, search);
            return ResponseEntity.ok(new ApiResponse("success", true, all));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(
                    "error", false, null
            ));
        }

    }

    @Override
    public HttpEntity getMovieById(UUID id) {
        CustomMovieById movieById = movieRepository.getMovieById(id).orElseThrow(()
                -> new ResourceNotFoundException("movie not found"));
        return ResponseEntity.ok(new ApiResponse("success", true, movieById));
    }

    @Override
    public HttpEntity saveMovie(MovieDto movieDto) {
        return null;
    }

    @Override
    public HttpEntity deleteMovieById(UUID id) {
        return null;
    }
}
