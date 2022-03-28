package uz.pdp.b6cinemarestservice.service.interfaces;

import org.springframework.http.HttpEntity;
import uz.pdp.b6cinemarestservice.dto.TicketDto;
import uz.pdp.b6cinemarestservice.model.Ticket;

import java.util.UUID;

public interface TicketService {


    HttpEntity createAndAddTicketToUsersCart(TicketDto ticketDto);


    void scheduleDeleteTicket(Ticket ticket);

    HttpEntity purchaseTicket(UUID ticketId);

    HttpEntity refundTicket(UUID ticketId);

    HttpEntity getTicketsByUserId(UUID userId);
}
