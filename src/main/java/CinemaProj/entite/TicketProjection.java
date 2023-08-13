package CinemaProj.entite;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticketProj",types = {CinemaProj.entite.Ticket.class})
public interface TicketProjection {

    public Long getId();
    public String getNomClient();
    public Double getPrix();
    public Integer getCodePayement();
    public Boolean getReservee();
    public Place getPlace();
}