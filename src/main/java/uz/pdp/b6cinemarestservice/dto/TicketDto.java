package uz.pdp.b6cinemarestservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDto {
    private UUID movieSessionId;
    private UUID seatId;



    private double price;
    private String movieTitle;
}
