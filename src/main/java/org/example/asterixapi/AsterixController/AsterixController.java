package org.example.asterixapi.AsterixController;

import lombok.RequiredArgsConstructor;
import org.example.asterixapi.model.Character;
import org.example.asterixapi.model.CharacterDTO;
import org.example.asterixapi.service.AsterixService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/asterix")

public class AsterixController {

    private final AsterixService asterixService;

    @GetMapping("/character")
    public List<Character> getCharacters(
            @RequestParam() int age) {
        return asterixService.getCharacters(age);
    }
    @PostMapping("/character/create")
    public Character addCharacter(@RequestBody CharacterDTO characterDTO) {
        return asterixService.save(characterDTO);
    }
    @GetMapping("/character/id")
    public Character getCharacterById(@RequestParam("id") String id) {
        return asterixService.getCharacterById(id);
    }
    @PostMapping("character/id")
    public Character updateCharacterById(@RequestParam String id,
            @RequestBody CharacterDTO characterDTO) {
        return asterixService.updateCharacterById(id,characterDTO);
    }
    @DeleteMapping("character/id")
    public void deleteCharacterById(@RequestParam("id") String id) {
        asterixService.deleteCharacterById(id);
    }

}
