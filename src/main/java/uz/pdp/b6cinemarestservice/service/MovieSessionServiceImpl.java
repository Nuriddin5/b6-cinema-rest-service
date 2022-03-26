package uz.pdp.b6cinemarestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.b6cinemarestservice.payload.ApiResponse;
import uz.pdp.b6cinemarestservice.projection.MovieSessionProjection;
import uz.pdp.b6cinemarestservice.repository.MovieSessionRepository;
import uz.pdp.b6cinemarestservice.service.interfaces.MovieSessionService;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {

    @Autowired
    MovieSessionRepository movieSessionRepository;

    @Override
    public HttpEntity getAllMovieSessions(int page, int size, String search) {
        Pageable pageable = PageRequest.of(
                page - 1,
                size
        );
        Page<MovieSessionProjection> all = movieSessionRepository.findAllSessionsByPage(
                pageable,
                search);

        return ResponseEntity.ok(new ApiResponse("success", true, all));

    }
}
