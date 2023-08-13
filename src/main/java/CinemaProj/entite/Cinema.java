package CinemaProj.entite;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor @ToString
public class Cinema implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(length = 75)
    private String name;
    private double longitude,latitude,altitude;
    private int nombreSalles;
    @OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles;
    @ManyToOne
    private Ville ville;


}
