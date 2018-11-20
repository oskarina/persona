package com.persona.domain;

public class PersonaBuilder {
    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String fotoUrl;

    public PersonaBuilder setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public PersonaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PersonaBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public PersonaBuilder setEdad(Integer edad) {
        this.edad = edad;
        return this;
    }

    public PersonaBuilder setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
        return this;
    }

    public Persona createPersona() {
        return new Persona(dni, nombre, apellido, edad, fotoUrl);
    }
}