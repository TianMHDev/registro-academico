package com.codeup.service;

import com.codeup.domain.Estudiante;
import com.codeup.domain.Nota;
import java.io.*;
import java.util.*;

public class ArchivoService {

    // Guardar estudiantes en CSV
    public void guardarCSV(File archivo, List<Estudiante> estudiantes) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            // Cabecera
            writer.println("id,nombre,edad,nota1,nota2,nota3");

            for (Estudiante e : estudiantes) {
                List<Nota> notas = e.getNotas();
                writer.printf("%s,%s,%d,%.2f,%.2f,%.2f%n",
                        e.getId(),
                        e.getNombre(),
                        e.getEdad(),
                        notas.get(0).getValor(),
                        notas.get(1).getValor(),
                        notas.get(2).getValor()
                );
            }
        }
    }

    // Cargar estudiantes desde CSV
    public List<Estudiante> cargarCSV(File archivo) throws IOException {
        List<Estudiante> estudiantes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine();

            // Validar cabecera
            if (linea == null || !linea.equals("id,nombre,edad,nota1,nota2,nota3")) {
                throw new IOException("Formato de archivo inválido. Debe contener: id,nombre,edad,nota1,nota2,nota3");
            }

            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] partes = linea.split(",");
                if (partes.length != 6) {
                    System.err.println("Omitiendo línea inválida: " + linea);
                    continue;
                }

                try {
                    String id = partes[0].trim();
                    String nombre = partes[1].trim();
                    int edad = Integer.parseInt(partes[2].trim());
                    double n1 = Double.parseDouble(partes[3].trim());
                    double n2 = Double.parseDouble(partes[4].trim());
                    double n3 = Double.parseDouble(partes[5].trim());

                    List<Nota> notas = Arrays.asList(
                            new Nota(n1),
                            new Nota(n2),
                            new Nota(n3)
                    );

                    // Crear estudiante usando el constructor con ID
                    Estudiante estudiante = new Estudiante(id, nombre, edad, notas);
                    estudiantes.add(estudiante);

                } catch (NumberFormatException e) {
                    System.err.println("Omitiendo línea por error de formato numérico: " + linea);
                }
            }

        } catch (Exception e) {
            throw new IOException("Error al leer CSV: " + e.getMessage(), e);
        }

        return estudiantes;
    }
}
