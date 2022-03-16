package uz.pdp.b6cinemarestservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.b6cinemarestservice.model.Cast;
import uz.pdp.b6cinemarestservice.model.enums.CastType;
import uz.pdp.b6cinemarestservice.service.interfaces.MovieService;

import static uz.pdp.b6cinemarestservice.utils.Constants.*;

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

}
