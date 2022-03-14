package uz.pdp.b6cinemarestservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.b6cinemarestservice.dto.CastDto;
import uz.pdp.b6cinemarestservice.model.Cast;
import uz.pdp.b6cinemarestservice.projection.CastProjection;
import uz.pdp.b6cinemarestservice.repository.CastRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CastService {

    @Autowired
    CastRepository castRepository;

    public List<CastProjection> getAllCastsByMovieId(@PathVariable(required = true) UUID movieId) {
        return castRepository.findByMovieId(movieId);
    }

    public List<Cast> getAllCasts() {
        return castRepository.findAll();

    }
}
