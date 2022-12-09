package cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.repository.FlorRepository;
import cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.services.FlorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flor")
public class FlorController {
    @Autowired
    private FlorRepository florRepository;
    @Autowired
    private FlorServiceImpl florServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<FlorEntity> anadirFlor(@RequestBody FlorEntity florEntity) {
        try {
            FlorEntity _flor = florRepository
                    .save(new FlorEntity(florEntity.getNomFlor(), florEntity.getPaisFlor()));
            return new ResponseEntity<>(_flor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FlorEntity> updateFlor(@PathVariable("id") long id, @RequestBody FlorEntity florEntity) {
        Optional<FlorEntity> fruitaData = florRepository.findById(id);

        if (fruitaData.isPresent()) {
            FlorEntity _flor = fruitaData.get();
            _flor.setNomFlor(florEntity.getNomFlor());
            _flor.setPaisFlor(florEntity.getPaisFlor());
            return new ResponseEntity<>(florRepository.save(_flor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFlor(@PathVariable("id") int id) {
        try {
            florRepository.deleteById((long) id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorEntity> getFlorById(@PathVariable("id") int id) {
        Optional<FlorEntity> florData = florRepository.findById((long) id);

        if (florData.isPresent()) {
            return new ResponseEntity<>(florData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDTO>> getAllFlores() {
        try {
            List<FlorDTO> floresDTO = florServiceImpl.getAllFlores();
            if (floresDTO.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(floresDTO, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

