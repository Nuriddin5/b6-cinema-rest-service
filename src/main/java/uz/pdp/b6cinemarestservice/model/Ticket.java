package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.enums.TicketStatus;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket extends AbsEntity {

    @ManyToOne
    private MovieSession movieSession;

    @ManyToOne
    private Seat seat;

    @OneToOne
    private Attachment qrCode;

    private Double price;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToOne
    private User user;

}
