package org.example.mappers;

import org.example.dtos.CharacterDTO;
import org.example.entities.MyCharacter;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper
public interface CharacterMapper {
    CharacterDTO entityToDTO(MyCharacter entity);
    MyCharacter DTOToEntity(CharacterDTO dto);
    List<CharacterDTO> entityToDTOList (List<MyCharacter> entity);
}
