package CinemaProj.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CategorieFilmDto {

    private Long id;

    private String name;




}
