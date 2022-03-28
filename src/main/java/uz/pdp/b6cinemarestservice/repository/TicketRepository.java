package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.b6cinemarestservice.model.Ticket;
import uz.pdp.b6cinemarestservice.projection.TicketProjection;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {


    @Query(nativeQuery = true, value = "select cast(t.id as varchar) as id,\n" +
            "       m.title,\n" +
            "       s.number              as seatNumber,\n" +
            "       hr.number             as rowNumber,\n" +
            "       h.name                as hallName,\n" +
            "       t.price,\n" +
            "       sd.date               as sessionDate,\n" +
            "       st.time               as sessionTime\n" +
            "from tickets t\n" +
            "         join seats s on t.seat_id = s.id\n" +
            "         join h_rows hr on s.row_id = hr.id\n" +
            "         join halls h on hr.hall_id = h.id\n" +
            "         join movie_sessions ms on ms.id = t.movie_session_id\n" +
            "         join movie_announcements ma on ms.movie_announcement_id = ma.id\n" +
            "         join movies m on ma.movie_id = m.id\n" +
            "         join session_dates sd on ms.start_date_id = sd.id\n" +
            "         join session_times st on ms.start_time_id = st.id\n" +
            "where t.user_id = :userId and t.status = 'NEW'")
    List<TicketProjection> getTicketByUserId(UUID userId);
}
