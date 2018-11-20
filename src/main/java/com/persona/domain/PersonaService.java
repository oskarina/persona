package com.persona.domain;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Service
public class PersonaService {

    private PersonaRepository personaRepository;
    private FotoRepository fotoRepository;

    public PersonaService(PersonaRepository personaRepository, FotoRepository fotoRepository) {
        this.personaRepository = personaRepository;
        this.fotoRepository = fotoRepository;
    }

    public Collection<Persona> listar(Persona persona) {
        return personaRepository.findAll(Example.of(persona));
    }

    public Persona alta(Persona persona, MultipartFile foto) {
        fotoRepository.persist(persona, foto);
        persona.setFotoUrl("http://localhost:8080/foto/" + persona.getDni() + ".jpg");
        return personaRepository.save(persona);
    }

    public Resource buscarFoto(String fileName) {
        return fotoRepository.loadAsResource(fileName);
    }
}
