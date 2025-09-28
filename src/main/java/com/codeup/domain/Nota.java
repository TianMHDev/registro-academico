package com.codeup.domain;

/**
 * Clase que representa una Nota de 0.0 a 5.0
 * @author sebastian
 */
public final class Nota {
    private double valor;

    public Nota(double valor) {
        if (valor < 0.0 || valor > 5.0) {
            throw new IllegalArgumentException("La nota debe estar entre 0.0 y 5.0");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0.0 || valor > 5.0) {
            throw new IllegalArgumentException("La nota debe estar entre 0.0 y 5.0");
        }
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%.2f", valor);
    }
}
