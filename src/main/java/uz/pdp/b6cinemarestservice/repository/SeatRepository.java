package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.b6cinemarestservice.model.Seat;
import uz.pdp.b6cinemarestservice.projection.AvailableSeatsProjection;

import java.util.List;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {


    @Query(nativeQuery = true,
    value = "select cast(s.id as varchar) as id,\n" +
            "       s.number              as seatNumber,\n" +
            "       hr.number             as rowNumber,\n" +
            "       true                  as available\n" +
            "from seats s\n" +
            "         join h_rows hr on s.row_id = hr.id\n" +
            "         join halls h on hr.hall_id = h.id\n" +
            "         join movie_sessions ms on h.id = ms.hall_id\n" +
            "where s.id not in (\n" +
            "    select t.seat_id\n" +
            "    from tickets t\n" +
            "             join movie_sessions ms on ms.id = t.movie_session_id\n" +
            "    where t.status <> 'REFUNDED'\n" +
            "      and ms.id = :movieSessionId\n" +
            ")\n" +
            "  and ms.id = :movieSessionId\n" +
            "union\n" +
            "select cast(s.id as varchar) as id,\n" +
            "       s.number              as seatNumber,\n" +
            "       hr.number             as rowNumber,\n" +
            "       false                 as available\n" +
            "from tickets t\n" +
            "         join seats s on t.seat_id = s.id\n" +
            "         join h_rows hr on s.row_id = hr.id\n" +
            "         join movie_sessions ms on ms.id = t.movie_session_id\n" +
            "where t.status <> 'REFUNDED'\n" +
            "  and ms.id = :movieSessionId\n" +
            "order by rowNumber, seatNumber")
    List<AvailableSeatsProjection> getAvailableSeatsBySessionId(UUID movieSessionId);
}
