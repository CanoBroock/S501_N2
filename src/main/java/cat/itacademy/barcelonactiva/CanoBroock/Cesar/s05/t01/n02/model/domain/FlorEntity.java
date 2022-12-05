package cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "flores")
public class FlorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_FlorID;

    @Column(name = "nombre_flor")
    private String nomFlor;

    @Column(name = "pais_flor")
    private String paisFlor;
}
