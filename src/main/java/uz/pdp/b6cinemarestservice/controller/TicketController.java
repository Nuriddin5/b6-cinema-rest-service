package uz.pdp.b6cinemarestservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.b6cinemarestservice.dto.TicketDto;
import uz.pdp.b6cinemarestservice.model.User;
import uz.pdp.b6cinemarestservice.repository.UserRepository;
import uz.pdp.b6cinemarestservice.service.interfaces.TicketService;

import java.util.UUID;


@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/get-my-tickets")
    public HttpEntity getTicketsByUserId() {
        // TODO: 3/28/2022 GET CURRENT USER'S ID
        User user = userRepository.findByUsername("test").orElseThrow(() ->
                new ResourceNotFoundException("User not found!!"));
        return ticketService.getTicketsByUserId(user.getId());
    }


    @PostMapping("/add-to-cart")
    public HttpEntity createAndAddTicketToUsersCart(@RequestBody TicketDto ticketDto) {
        return ticketService.createAndAddTicketToUsersCart(ticketDto);
    }


    @GetMapping("/purchase/{ticketId}")
    public HttpEntity purchaseTicket(@PathVariable UUID ticketId) {
        return ticketService.purchaseTicket(ticketId);
    }
}
