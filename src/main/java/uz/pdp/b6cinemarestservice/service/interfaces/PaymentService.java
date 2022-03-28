package uz.pdp.b6cinemarestservice.service.interfaces;

import com.stripe.exception.StripeException;
import org.springframework.http.HttpEntity;
import uz.pdp.b6cinemarestservice.dto.TicketDto;

import java.util.List;

public interface PaymentService {
    HttpEntity createStripeSession(List<TicketDto> ticketDtoList) throws StripeException;
}
