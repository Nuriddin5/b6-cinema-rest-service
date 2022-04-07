package uz.pdp.b6cinemarestservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.b6cinemarestservice.service.interfaces.MovieService;

import java.util.UUID;

import static uz.pdp.b6cinemarestservice.utils.Constant.*;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;


    @GetMapping
    public HttpEntity getAllMovies(
            @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "search", defaultValue = "") String search,
            @RequestParam(name = "sort", defaultValue = "title") String sort,
            @RequestParam(name = "direction", defaultValue = "true") boolean direction
    ) {
        return movieService.getAllMovies(size, page, search, sort, direction);
    }


    @GetMapping("/{id}")
    public HttpEntity getMovieById(@PathVariable UUID id) {
        return movieService.getMovieById(id);
    }

    // TODO: 4/6/2022 add dto and implement this method
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HttpEntity saveMovie() {
        return ResponseEntity.ok("New movie has been saved...!!");
    }

}
