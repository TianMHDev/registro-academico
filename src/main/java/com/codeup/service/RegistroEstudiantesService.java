/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.service;

import com.codeup.domain.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastian
 */

public class RegistroEstudiantesService {
    private final List<Estudiante> estudiantes = new ArrayList<>();

    public void agregarEstudiante(Estudiante e) {
        if (e == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        estudiantes.add(e);
    }

    public List<Estudiante> listarEstudiantes() {
        // Devolvemos una copia para no modificar la lista original desde fuera
        return new ArrayList<>(estudiantes);
    }
}
