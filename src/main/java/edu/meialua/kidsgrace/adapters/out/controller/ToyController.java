package edu.meialua.kidsgrace.adapters.out.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.meialua.kidsgrace.adapters.in.Toy;
import edu.meialua.kidsgrace.adapters.in.repositories.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/toys")
public class ToyController {
    @Autowired
    ToyRepository toyRepository;

    @Autowired
    ObjectMapper objectMapper;

    // http://localhost:8080/toys/findAll
    @GetMapping("/findAll")
    public ResponseEntity<String> getToys() throws JsonProcessingException {
        List<Toy> toys = toyRepository.findAll();

        if(!toys.isEmpty()) {
            return ResponseEntity.ok(objectMapper.writeValueAsString(toys));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BRINQUEDOS NÃO ENCONTRADOS");
    }

    // http://localhost:8080/toys/findByName
    @GetMapping("/findByName/{name}")
    public ResponseEntity<String> getToyByName(@PathVariable("name") String name) throws JsonProcessingException {
        Optional<Toy> toy = toyRepository.findByName(name);

        if(!toy.isEmpty()) {
            return ResponseEntity.ok(objectMapper.writeValueAsString(toy));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BRINQUEDO NÃO ENCONTRADO COM ESSE NOME");
    }

    // http://localhost:8080/toys/findAllByBrand
    @GetMapping("/findAllByBrand/{brand}")
    public ResponseEntity<String> getToysByBrand(@PathVariable("brand") String brand) throws JsonProcessingException {
        List<Toy> toys = toyRepository.findAllByBrand(brand);

        if(!toys.isEmpty()) {
            return ResponseEntity.ok(objectMapper.writeValueAsString(toys));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BRINQUEDOS NÃO ENCONTRADOS COM ESSA MARCA");
    }

    // http://localhost:8080/toys/findAllByCategpry
    @GetMapping("/findAllByCategory/{category}")
    public ResponseEntity<String> getToysByCategory(@PathVariable("category") String category) throws JsonProcessingException {
        List<Toy> toys = toyRepository.findAllByCategory(category);

        if(!toys.isEmpty()) {
            return ResponseEntity.ok(objectMapper.writeValueAsString(toys));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BRINQUEDOS NÃO ENCONTRADOS COM ESSA CATEGORIA");
    }


    // http://localhost:8080/toys/insert
    @PostMapping("/insert")
    public ResponseEntity<String> createToy(@RequestBody Toy toy) {
        // Verificar se o Toy existe
        Optional<Toy> toyOpt = toyRepository.findById(toy.getId());
        if (toyOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("BRINQUEDO JÁ CADASTRADO!");
        }
        toyRepository.save(toy);

        return ResponseEntity.status(HttpStatus.CREATED).body("BRINQUEDO INSERIDO COM SUCESSO.");

    }


    // http://localhost:8080/toys/deleteById/{id}
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        // Verifica se existe um toy com o ID fornecido
        Optional<Toy> existingToy = toyRepository.findById(id);
        if (existingToy.isPresent()) {
            toyRepository.deleteById(id);
            return ResponseEntity.ok("BRINQUEDO DELETADO COM SUCESSO PELO ID.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NENHUM BRINQUEDO ENCONTRADO COM ESSE ID.");
        }
    }

    // http://localhost:8080/toys/update
    @PutMapping("/update")
    public ResponseEntity<String> updateToy(@RequestBody Toy toy) {
        // Verificar se o Toy existe
        Optional<Toy> toyOpt = toyRepository.findById(toy.getId());
        if (toyOpt.isPresent()) {
            toyRepository.save(toy);
            return ResponseEntity.status(HttpStatus.CREATED).body("BRINQUEDO ATUALIZADO COM SUCESSO.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BRINQUEDO COM ESSES DADOS NÃO ENCONTRADO");
    }


}
