/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.domain;

/**
 *
 * @author sebastian
 */
public class Nota {
    private double valor;

    public Nota(double valor) {
        if (valor < 0 || valor > 5) { // ejemplo: escala de 0 a 5
            throw new IllegalArgumentException("La nota debe estar entre 0 y 5.");
        }
        this.valor = valor;
    }

    public double getValor() { return valor; }

    public void setValor(double valor) {
        if (valor < 0 || valor > 5) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 5.");
        }
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%.2f", valor);
    }
}
