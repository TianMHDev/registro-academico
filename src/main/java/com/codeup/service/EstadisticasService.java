/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.service;

/**
 *
 * @author sebastian
 */
import com.codeup.domain.Estudiante;
import com.codeup.domain.Nota;
import java.util.List;

public class EstadisticasService {

    private final CalculoService calculoService = new CalculoService();

    // Promedio general de todos los estudiantes
    public double promedioGeneral(List<Estudiante> estudiantes) {
        if (estudiantes == null || estudiantes.isEmpty()) {
            throw new IllegalArgumentException("No hay estudiantes registrados.");
        }

        double suma = 0;
        for (Estudiante e : estudiantes) {
            suma += calculoService.promedio(e.getNotas());
        }
        return suma / estudiantes.size();
    }

    // Nota más alta de todo el grupo
    public Nota notaMaximaGrupo(List<Estudiante> estudiantes) {
        if (estudiantes == null || estudiantes.isEmpty()) {
            throw new IllegalArgumentException("No hay estudiantes registrados.");
        }

        Nota max = null;
        for (Estudiante e : estudiantes) {
            Nota notaEst = calculoService.notaMaxima(e.getNotas());
            if (max == null || notaEst.getValor() > max.getValor()) {
                max = notaEst;
            }
        }
        return max;
    }

    // Contar aprobados
    public long contarAprobados(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .filter(e -> calculoService.aprobadoReprobado(
                        calculoService.promedio(e.getNotas())))
                .count();
    }

    // Contar reprobados
    public long contarReprobados(List<Estudiante> estudiantes) {
        return estudiantes.size() - contarAprobados(estudiantes);
    }

    // Mejor estudiante (mayor promedio)
    public Estudiante mejorEstudiante(List<Estudiante> estudiantes) {
        Estudiante mejor = estudiantes.get(0);
        double mejorProm = calculoService.promedio(mejor.getNotas());

        for (Estudiante e : estudiantes) {
            double prom = calculoService.promedio(e.getNotas());
            if (prom > mejorProm) {
                mejor = e;
                mejorProm = prom;
            }
        }
        return mejor;
    }

    // Peor estudiante (menor promedio)
    public Estudiante peorEstudiante(List<Estudiante> estudiantes) {
        Estudiante peor = estudiantes.get(0);
        double peorProm = calculoService.promedio(peor.getNotas());

        for (Estudiante e : estudiantes) {
            double prom = calculoService.promedio(e.getNotas());
            if (prom < peorProm) {
                peor = e;
                peorProm = prom;
            }
        }
        return peor;
    }
}

