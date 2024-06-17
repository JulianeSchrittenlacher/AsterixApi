package org.example.asterixapi.service;

import lombok.RequiredArgsConstructor;
import org.example.asterixapi.model.Character;
import org.example.asterixapi.repository.CharacterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class AsterixService {
    private final CharacterRepo characterRepo;

    public List<Character> getCharacters() {
        return characterRepo.findAll();
    }

    public Character save(Character character) {
        return characterRepo.save(character);
    }
}
