package org.example.asterixapi.service;

import lombok.RequiredArgsConstructor;
import org.example.asterixapi.model.Character;
import org.example.asterixapi.model.CharacterDTO;
import org.example.asterixapi.repository.CharacterRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service

public class AsterixService {
    private final CharacterRepo characterRepo;
    private final IdService idService;

    public List<Character> getCharacters(int age) {
        return characterRepo.findAll().stream()
                .filter(c -> c.age()<=age)
                .toList();
    }

    public Character fromDTO(CharacterDTO dto) {
        String id = idService.randomId();
        return new Character(id,dto.name(),dto.age(),dto.profession());
    }

    public Character save(CharacterDTO characterDTO) {
        return characterRepo.save(fromDTO(characterDTO));
    }


    public Character getCharacterById(String id) {
        return characterRepo.findById(id).orElseThrow();
    }

    public Character updateCharacterById(String id, CharacterDTO characterDTO) {
        deleteCharacterById(id);
        Character updatedCharacter = new Character(id,characterDTO.name(),characterDTO.age(),characterDTO.profession());
        characterRepo.save(updatedCharacter);
        return updatedCharacter;
    }

    public void deleteCharacterById(String id) {
        characterRepo.deleteById(id);
    }
}
