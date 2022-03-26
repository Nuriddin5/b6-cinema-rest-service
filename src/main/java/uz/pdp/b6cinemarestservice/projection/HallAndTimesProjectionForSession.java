package uz.pdp.b6cinemarestservice.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.UUID;

public interface HallAndTimesProjectionForSession {

    UUID getId();

    String getName();

//
//    UUID getMovieAnnouncementId();
//
//    UUID getStartDateId();

    @Value("#{@sessionTimeRepository.getTimesByHallIdAndAnnouncementIdAndStartDateId(target.id, target.movieAnnouncementId, target.startDateId)}")
    List<SessionTimeProjection> getTimes();


}
