package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.b6cinemarestservice.model.Row;
import uz.pdp.b6cinemarestservice.projection.RowProjection;

import java.util.List;
import java.util.UUID;

public interface RowRepository extends JpaRepository<Row, UUID> {


    @Query(value = "SELECT " +
            " cast(r.id as varchar) as id, r.number, h.name as hallName FROM rows r " +
            "join halls h on r.hall_id = h.id\n" +
            "where h.id = :hallId", nativeQuery = true)
    List<RowProjection> getRowsByHallId(UUID hallId);


}
