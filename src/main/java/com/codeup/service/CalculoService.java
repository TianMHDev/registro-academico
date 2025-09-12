/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.service;

import com.codeup.domain.Nota;
import java.util.List;

/**
 *
 * @author sebastian
 */
public class CalculoService {

    // Calcular promedio de una lista de notas
    public double promedio(List<Nota> notas) {
        if (notas == null || notas.isEmpty()) {
            throw new IllegalArgumentException("La lista de notas no puede estar vacía.");
        }

        double suma = 0;
        for (Nota n : notas) {
            suma += n.getValor();
        }
        return suma / notas.size();
    }

    // Encontrar la nota máxima
    public Nota notaMaxima(List<Nota> notas) {
        if (notas == null || notas.isEmpty()) {
            throw new IllegalArgumentException("La lista de notas no puede estar vacía.");
        }

        Nota mayor = notas.get(0);
        for (Nota n : notas) {
            if (n.getValor() > mayor.getValor()) {
                mayor = n;
            }
        }
        return mayor;
    }

    // Saber si el promedio es aprobado o reprobado
    public boolean aprobadoReprobado(double promedio) {
        return promedio >= 3.0;
    }
}