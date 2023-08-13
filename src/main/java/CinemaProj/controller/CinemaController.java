package CinemaProj.controller;

import CinemaProj.entite.Film;
import CinemaProj.entite.Ticket;
import CinemaProj.repository.FilmRepository;
import CinemaProj.repository.TicketRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")

public class CinemaController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @GetMapping(path = "/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name = "id") Long id) throws Exception {
        Film f=filmRepository.findById(id).get();
        String photoName= f.getPhoto();
        File file= new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){

        List<Ticket> ticketList=new ArrayList<>();

        ticketForm.getTickets().forEach(idTicket->{
            //System.out.println(idTicket);
            Ticket ticket=ticketRepository.findById(idTicket).get();
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setReservee(true);
            ticket.setCodePayement(ticketForm.getCodePayement());
            ticketRepository.save(ticket);
            ticketList.add(ticket);
        });
        return ticketList;

    }
    @GetMapping("/getTicket")
    public Ticket getTickets(){

        return this.ticketRepository.findById(Long.valueOf(5639)).get();
    }

}
@Data
class TicketForm{
    private String nomClient;
    private int codePayement;
    private  List<Long> tickets=new ArrayList<>();
}
