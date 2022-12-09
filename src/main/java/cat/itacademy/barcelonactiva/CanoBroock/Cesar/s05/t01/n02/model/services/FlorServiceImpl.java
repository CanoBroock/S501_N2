package cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlorServiceImpl implements FlorService{
    @Autowired
    private FlorRepository florRepository;

    private FlorDTO convertEntityToDTO(FlorEntity florEntity) {
        FlorDTO florDTO = new FlorDTO();
        florDTO.setPk_FlorID((int) florEntity.getPk_FlorID());
        florDTO.setNomFlor(florEntity.getNomFlor());
        florDTO.setPaisFlor(florEntity.getPaisFlor());
        return florDTO;
    }

    @Override
    public List<FlorDTO> getAllFlores() {
        return florRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public void saveFlor(FlorEntity florEntity) {
        this.florRepository.save(florEntity);
    }

    @Override
    public FlorEntity getFlorById(long id) {
        Optional<FlorEntity> optional = florRepository.findById(id);
        FlorEntity florEntity = null;
        if (optional.isPresent()) {
            florEntity = optional.get();
        } else {
            throw new RuntimeException(" Flor not found for id :: " + id);
        }
        return florEntity;
    }

    @Override
    public void deleteFlorById(long id) {
        this.florRepository.deleteById(id);
    }
}
