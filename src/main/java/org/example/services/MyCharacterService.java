package org.example.services;

import org.example.dtos.CharacterDTO;
import org.example.entities.MyCharacter;
import org.example.mappers.CharacterMapper;
import org.example.repositories.ICharacterRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class MyCharacterService {
    private final ICharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    public List<CharacterDTO> findAll() {
       List<MyCharacter> list = this.characterRepository.findAll();
       return this.characterMapper.entityToDTOList(list);
    }

    public CharacterDTO findById(Long id) {
        var optionalCharacter = this.characterRepository.findById(id);
        if(optionalCharacter.isEmpty()) throw new RuntimeException("El character con id: " + id + " no existe");
        MyCharacter character= optionalCharacter.get();
        return this.characterMapper.entityToDTO(character);
    }

    public CharacterDTO create(CharacterDTO character) {
        MyCharacter myCharacter=this.characterMapper.DTOToEntity(character);
        MyCharacter myCharacterCreate= this.characterRepository.save(myCharacter);
        return this.characterMapper.entityToDTO(myCharacterCreate);
    }

    public void deleteCharacter(Long id) {
        this.characterRepository.deleteById(id);
    }

    public CharacterDTO update(CharacterDTO character) {
        MyCharacter myCharacter=this.characterMapper.DTOToEntity(character);
        MyCharacter myCharacterCreate= this.characterRepository.save(myCharacter);
        return this.characterMapper.entityToDTO(myCharacterCreate);
    }
}
