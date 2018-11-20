package com.persona.domain;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FotoRepository {

    private final Path rootLocation = Paths.get("c://fotosPersonas");

    public String persist(Persona persona, MultipartFile fotoPersona) {
        String filename = persona.getDni() + ".jpg";
        try {
            if (fotoPersona.isEmpty()) {
                throw new RuntimeException("Failed to store empty file " + filename);
            }

            try (InputStream inputStream = fotoPersona.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + filename, e);
        }

        return filename;
    }

    public Resource loadAsResource(String fileName) {
        try {
            Path file = load(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException(
                        "Could not read file: " + fileName);

            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + fileName, e);
        }
    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }
}
