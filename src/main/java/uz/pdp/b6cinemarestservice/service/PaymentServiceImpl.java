package uz.pdp.b6cinemarestservice.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.b6cinemarestservice.dto.StripeResponseDto;
import uz.pdp.b6cinemarestservice.dto.TicketDto;
import uz.pdp.b6cinemarestservice.service.interfaces.PaymentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${STRIPE_SECRET_KEY}")
    String stripeApiKey;

    @Value("${BASE_URL}")
    String baseUrl;

    @Override
    public HttpEntity createStripeSession(List<TicketDto> ticketDtoList) throws StripeException {
        // SUCCESS and FAILURE URLS
        String successURL = baseUrl + "payment/success";
        String failureURL = baseUrl + "payment/failed";

        Stripe.apiKey = stripeApiKey;

        List<SessionCreateParams.LineItem> sessionItemList = new ArrayList<>();

        for (TicketDto ticketDto : ticketDtoList) {
            sessionItemList.add(createSessionLineItem(ticketDto));
        }

        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setCancelUrl(failureURL)
                .setSuccessUrl(successURL)
                .addAllLineItem(sessionItemList)
                .build();

        Session session = Session.create(params);

        StripeResponseDto stripeResponse = new StripeResponseDto(session.getId());
        return ResponseEntity.ok(stripeResponse);

    }

    private SessionCreateParams.LineItem createSessionLineItem(TicketDto ticketDto) {
        return SessionCreateParams.LineItem.builder()
                .setPriceData(createPriceData(ticketDto))
                .setQuantity(1L)
                .build();
    }

    private SessionCreateParams.LineItem.PriceData createPriceData(TicketDto ticketDto) {
        return SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency("usd")
                .setUnitAmount((long) ticketDto.getPrice() * 100)
                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                        .setName(ticketDto.getMovieTitle())
                        .build())
                .build();
    }
}
