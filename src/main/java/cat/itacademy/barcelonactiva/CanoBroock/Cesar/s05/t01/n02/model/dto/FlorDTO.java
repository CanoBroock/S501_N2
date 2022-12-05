package cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class FlorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> floresUE = new ArrayList<>(Arrays.asList("Alemania", "Belgica", "Croacia", "España", "Francia", "Irlanda",
            "Letonia", "Luxemburgo", "Paises Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta",
            "Polonia", "Republica Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungria", "Italia",
            "Lituania", "Portugal", "Rumania"));

    private int pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipoFlor;

    public void setTipoFlor (String paisFlor) {
        this.paisFlor = paisFlor;
        florUE();
    }

    public void florUE() {
        boolean controlador = false;
        int i = 0;

        while (i < floresUE.size() && controlador == false) {
            if (paisFlor.equalsIgnoreCase(floresUE.get(i))) {
                tipoFlor = "Dentro de la UE";
                controlador = true;
            }
            i++;
        }
        if (controlador == false) {
            tipoFlor = "Fuera de la UE";
        }
        setTipoFlor(tipoFlor);
    }
}
