package cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.dto.FlorDTO;

import java.util.List;

public interface FlorService {
    List<FlorDTO> getAllFlores();
    void saveFlor(FlorEntity florEntity);
    FlorEntity getFlorById(long id);
    void deleteFlorById(long id);
}
