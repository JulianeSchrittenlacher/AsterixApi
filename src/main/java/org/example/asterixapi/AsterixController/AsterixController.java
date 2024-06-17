package org.example.asterixapi.AsterixController;

import lombok.RequiredArgsConstructor;
import org.example.asterixapi.model.Character;
import org.example.asterixapi.repository.CharacterRepo;
import org.example.asterixapi.service.AsterixService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/asterix")

public class AsterixController {

    private final AsterixService asterixService;

    @GetMapping("/character")
    public List<Character> getCharacters() {
        return asterixService.getCharacters();
    }
    @PostMapping("/character/create")
    public Character addCharacter(@RequestBody Character character) {
        return asterixService.save(character);
    }
}
