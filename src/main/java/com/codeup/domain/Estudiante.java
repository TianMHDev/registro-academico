/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastian
 */
public class Estudiante {
    private final String id;
    private String nombre;
    private int edad;
    private final List<Nota> notas; 

<<<<<<< HEAD
    // Constructor con validaciones
    public Estudiante(String id, String nombre, int edad, List<Nota> notas) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío.");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        if (notas == null || notas.size() != 3) {
            throw new IllegalArgumentException("Debe tener exactamente 3 notas.");
        }

        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.notas = new ArrayList<>(notas);
    }

    // Getters y setters con validación
=======
    public Estudiante(String nombreEst, int edadEst, List<Nota> notas) {
    if (nombreEst == null || nombreEst.isEmpty()) {
        throw new IllegalArgumentException("El nombre no puede estar vacío.");
    }
    if (edadEst < 0) {
        throw new IllegalArgumentException("La edad no puede ser negativa.");
    }
    if (notas == null || notas.size() != 3) {
        throw new IllegalArgumentException("Debe tener exactamente 3 notas.");
    }

    this.id = java.util.UUID.randomUUID().toString(); // Genera un id único
    this.nombre = nombreEst;
    this.edad = edadEst;
    this.notas = new ArrayList<>(notas);
    
}
public Estudiante(String idEst, String nombreEst, int edadEst, List<Nota> notas) {
    if (idEst == null || idEst.isEmpty()) {
        throw new IllegalArgumentException("El id no puede estar vacío.");
    }
    if (nombreEst == null || nombreEst.isEmpty()) {
        throw new IllegalArgumentException("El nombre no puede estar vacío.");
    }
    if (edadEst < 0) {
        throw new IllegalArgumentException("La edad no puede ser negativa.");
    }
    if (notas == null || notas.size() != 3) {
        throw new IllegalArgumentException("Debe tener exactamente 3 notas.");
    }

    this.id = idEst;
    this.nombre = nombreEst;
    this.edad = edadEst;
    this.notas = new ArrayList<>(notas);
}

    
>>>>>>> develop
    public String getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    public List<Nota> getNotas() {
        return new ArrayList<>(notas); // copia para proteger
    }

    // Cambiar una nota puntual con validación
    public void setNota(int indice, Nota nuevaNota) {
        if (indice < 0 || indice >= 3) {
            throw new IndexOutOfBoundsException("El estudiante solo tiene 3 notas.");
        }
        if (nuevaNota == null) {
            throw new IllegalArgumentException("La nota no puede ser nula.");
        }
        notas.set(indice, nuevaNota);
    }

    // Métodos útiles
    public double calcularPromedio() {
        double suma = 0;
        for (Nota n : notas) {
            suma += n.getValor();
        }
        return suma / notas.size();
    }

    public boolean estaAprobado() {
        return calcularPromedio() >= 3.0;
    }

<<<<<<< HEAD
    public double promedioNotas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
=======
   public double promedioNotas() {
    return calcularPromedio();
}

>>>>>>> develop
}

