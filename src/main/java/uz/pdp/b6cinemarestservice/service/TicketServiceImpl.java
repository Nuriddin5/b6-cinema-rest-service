package uz.pdp.b6cinemarestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.b6cinemarestservice.dto.TicketDto;
import uz.pdp.b6cinemarestservice.model.*;
import uz.pdp.b6cinemarestservice.model.enums.TicketStatus;
import uz.pdp.b6cinemarestservice.payload.ApiResponse;
import uz.pdp.b6cinemarestservice.projection.TicketProjection;
import uz.pdp.b6cinemarestservice.repository.*;
import uz.pdp.b6cinemarestservice.service.interfaces.TicketService;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    MovieSessionRepository movieSessionRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PurchaseHistoryRepository purchaseHistoryRepository;


    /**
     * USER JOYNI TANLAGANDA O'SHA JOYNI IDSI VA SEANSNI IDSI NI YUBORADI.
     * VA TICKET TABLE GA YANGE TICKET STATUSI NEW HOLATDA QO'SHILADI
     *
     * @param ticketDto
     * @return
     */
    @Override
    public HttpEntity createAndAddTicketToUsersCart(TicketDto ticketDto) {


        MovieSession movieSession = movieSessionRepository.findById(ticketDto.getMovieSessionId()).orElseThrow(() ->
                new ResourceNotFoundException("Movie Session not found"));

        Seat seat = seatRepository.findById(ticketDto.getSeatId()).orElseThrow(() ->
                new ResourceNotFoundException("Selected seat not found"));

        // TODO: 3/28/2022 FINISH IMPLEMENTING THIS METHOD
        Double finalPrice = getTicketFinalPrice(movieSession, seat);

        // TODO: 3/28/2022 WILL CHANGE IT LATER TO CURRENT USER
        User user = userRepository.findByUsername("test").orElseThrow(() ->
                new ResourceNotFoundException("user not found"));

        Ticket ticket = new Ticket(movieSession, seat, finalPrice, user);

        Ticket savedTicket = ticketRepository.save(ticket);

        // TICKET SAVATDAN O'CHIB KETISHI UCHUN BERILGAN VAQT BO'YICHA HISOBLASHNI BOSHLASH
        scheduleDeleteTicket(savedTicket);

        return ResponseEntity.ok(new ApiResponse("success", true, null));
    }

    /**
     * BU METHODNI VAZIFASI TICKET OXIRGI NARXINI (VIP ZAL BO'LSA, JOYIGA QARAB, SEANS VAQTIGA QARAB
     * QO'SHIMCHA TO'LOV) HISOBLAB BERISH
     *
     * @param movieSession
     * @param seat
     * @return
     */
    private Double getTicketFinalPrice(MovieSession movieSession, Seat seat) {
//        movieSession.getMovieAnnouncement().getMovie().getMinPrice()
//        seat.getPriceCategory().getAddAddFeeInPercent()
//        movieSession.getHall().getVipAddFeeInPercent()
//        movieSession.getStartTime().getTime()
        // TODO: 3/28/2022 CALCULATE TICKET FINAL PRICE
        return 50000.0;
    }


    public void scheduleDeleteTicket(Ticket ticket) {
        try {
            //=============== SIZ BERGAN VAZIFA========================

            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    Ticket ticketFromDb = ticketRepository.findById(ticket.getId()).orElseThrow(() ->
                            new ResourceNotFoundException("Ticket not found!!!"));
                    if (ticketFromDb.getStatus().equals(TicketStatus.NEW)) {
                        System.out.println(ticketFromDb.getId() + " Ticket deleted... " + new Date());
                        ticketRepository.delete(ticketFromDb);
                    }
                }
            };

            // ==============================================================


            // =============== BERILGAN VAZIFANI QACHON ISHGA TUSHIRISH UCHUN BERILGAN VAQT ==================
            Timer timer = new Timer();
//            long delayTime =  THIRTY_MINUTES_IN_MILLISECOND;
            long delayTime = 15000;


            System.out.println("Scheduler started..." + new Date());
            System.out.println("Delay: " + delayTime);

            // BERILGAN VAZIFA (timerTask) 15 sekunddan (delayTime = 15000) keyin amalga oshiriladi
            timer.schedule(timerTask, delayTime);


            //===================================================
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Transactional
    @Override
    public HttpEntity purchaseTicket(UUID ticketId) {


        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() ->
                new ResourceNotFoundException("Ticket not found"));

        if (!ticket.getStatus().equals(TicketStatus.NEW)) {
            return new ResponseEntity("Uje to'langan!", HttpStatus.BAD_REQUEST);
        }

        // TODO: 3/28/2022 IMPLEMENT STRIPE PAYMENT INTEGRATION


        //ticket.getPrice()
        // movieTitle
        // seatNumber, rowNumber


        // CLIENT -> SERVER -> STRIPE ->
        // CHECKOUT PAGE -> STRIPE -> CLIENT


        purchaseHistoryRepository.save(new PurchaseHistory(ticket.getUser(), ticket));

        ticket.setStatus(TicketStatus.PURCHASED);
        ticketRepository.save(ticket);


        return ResponseEntity.ok(new ApiResponse("Ticket successfully purchased", true, null));
    }

    @Override
    public HttpEntity refundTicket(UUID ticketId) {

        // TODO: 3/28/2022 IMPLEMENT STRIPE REFUND INTEGRATION


        // TODO: 3/28/2022
        return null;
    }

    @Override
    public HttpEntity getTicketsByUserId(UUID userId) {
        List<TicketProjection> ticketsByUserId = ticketRepository.getTicketByUserId(userId);
        return ResponseEntity.ok(new ApiResponse("success", true, ticketsByUserId));
    }
}
