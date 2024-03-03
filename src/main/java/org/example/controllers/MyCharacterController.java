package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.dtos.CharacterDTO;
import org.example.services.MyCharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@AllArgsConstructor
public class MyCharacterController {
    private final MyCharacterService myCharacterService;

    @GetMapping("/characters")
    public ResponseEntity<List<CharacterDTO>> getAll() {
        return ResponseEntity.ok(this.myCharacterService.findAll());
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<CharacterDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.myCharacterService.findById(id));
    }

    @PostMapping("/characters")
    public ResponseEntity<CharacterDTO> create(@RequestBody CharacterDTO character){
        return ResponseEntity.ok(this.myCharacterService.create(character));
    }

    @DeleteMapping("/characters/{id}")
    public void deleteById(@PathVariable Long id){
        this.myCharacterService.deleteCharacter(id);
    }

    @PutMapping("/characters/{id}")
    public ResponseEntity<CharacterDTO> update(@PathVariable Long id, @RequestBody CharacterDTO updatedCharacter) {
        CharacterDTO existingCharacter = this.myCharacterService.findById(id);

        if (existingCharacter == null) {
            return ResponseEntity.notFound().build();
        }

        existingCharacter.setName(updatedCharacter.getName());
        existingCharacter.setImg(updatedCharacter.getImg());
        existingCharacter.setDescription(updatedCharacter.getDescription());


        CharacterDTO updatedCharacterEntity = this.myCharacterService.update(existingCharacter);

        return ResponseEntity.ok(updatedCharacterEntity);
    }

}
