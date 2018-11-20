package com.persona.domain;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
public class PersonaController {

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    private PersonaService personaService;

    @GetMapping(path="/personas")
    public Collection<Persona> listarFiltrado(@RequestParam Optional<String> dni,
                                              @RequestParam Optional<String> nombre,
                                              @RequestParam Optional<Integer> edad) {

        Persona persona = new PersonaBuilder()
                .setNombre(nombre.orElseGet(() -> null))
                .setEdad(edad.orElseGet(() -> null))
                .setDni(dni.orElseGet(() -> null))
                .createPersona();

        return personaService.listar(persona);
    }

    @PostMapping("/persona")
    public Persona altaPersona(@RequestPart Persona persona, @RequestPart MultipartFile fotoPersona) {
        return personaService.alta(persona, fotoPersona);
    }

    @GetMapping(path = "foto/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource buscarFoto(@PathVariable String fileName) {
        return personaService.buscarFoto(fileName);
    }
}
