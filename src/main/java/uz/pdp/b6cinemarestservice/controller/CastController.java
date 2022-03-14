package uz.pdp.b6cinemarestservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.b6cinemarestservice.dto.CastDto;
import uz.pdp.b6cinemarestservice.model.Cast;
import uz.pdp.b6cinemarestservice.payload.ApiResponse;
import uz.pdp.b6cinemarestservice.projection.CastProjection;
import uz.pdp.b6cinemarestservice.service.CastService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/casts")
public class CastController {

    @Autowired
    CastService castService;


    @GetMapping
    public HttpEntity getAllCasts() {
        List<Cast> allCasts = castService.getAllCasts();

        ApiResponse res = new ApiResponse("success", true, allCasts);

        return ResponseEntity.ok(res);


    }

    @GetMapping("/{movieId}")
    public HttpEntity getAllCastsByMovieId(@PathVariable(required = true) UUID movieId) {
        List<CastProjection> allCastsByMovieId = castService.getAllCastsByMovieId(movieId);

        ApiResponse res = new ApiResponse("success", true, allCastsByMovieId);

        return ResponseEntity.ok(res);


    }
}
