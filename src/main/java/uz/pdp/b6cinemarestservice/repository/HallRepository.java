package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.b6cinemarestservice.model.Hall;
import uz.pdp.b6cinemarestservice.projection.HallAndTimesProjectionForSession;

import java.util.List;
import java.util.UUID;

public interface HallRepository extends JpaRepository<Hall, UUID> {


    @Query(nativeQuery = true, value = "select distinct" +
            " cast(h.id as varchar) as id,\n" +
            "       h.name, \n" +
            " cast(rh.start_date_id as varchar) as startDateId,\n" +
            " cast(movie_announcement_id as varchar) as movieAnnouncementId\n" +
            "from halls h\n" +
            "         join movie_sessions rh on h.id = rh.hall_id\n" +
            "where rh.start_date_id = :startDateId\n" +
            "  and movie_announcement_id = :movieAnnouncementId")
    List<HallAndTimesProjectionForSession> getHallsAndTimesByMovieAnnouncementIdAndStartDateId(UUID movieAnnouncementId, UUID startDateId);

//    @Query(nativeQuery = true, value = "select\n" +
//            "    cast(h.id as varchar) as id,\n" +
//            "    h.name,\n" +
////            "    cast(rh.start_date_id as varchar) as startDateId,\n" +
////            "    cast(movie_announcement_id as varchar) as movieAnnouncementId,\n" +
//            "    json_agg(json_build_object('id', cast(st.id as varchar),'time', st.time)) as times\n" +
//            "from halls h\n" +
//            "         join movie_sessions rh on h.id = rh.hall_id\n" +
//            "         join session_times st on rh.start_time_id = st.id\n" +
//            "where rh.start_date_id = :startDateId\n" +
//            "  and movie_announcement_id = :movieAnnouncementId\n" +
//            "group by h.id, rh.start_date_id, movie_announcement_id")
//    List<HallAndTimesProjectionForSession> getHallsByMovieAnnouncementIdAndStartDateId(UUID movieAnnouncementId, UUID startDateId);


}
