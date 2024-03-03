package org.example.repositories;


import org.example.entities.MyCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterRepository extends JpaRepository<MyCharacter, Long> {
}
