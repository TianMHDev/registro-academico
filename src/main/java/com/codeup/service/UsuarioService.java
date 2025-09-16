/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.service;

/**
 *
 * @author sebastian
 */
import com.codeup.domain.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        // Usuarios de ejemplo (puedes cargar de archivo o BD más adelante)
        usuarios.add(new Usuario("admin", "1234"));
        usuarios.add(new Usuario("sebastian", "dev2025"));
    }

    public boolean autenticar(String username, char[] password) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) &&
                u.getPassword().equals(new String(password))) {
                return true;
            }
        }
        return false;
    }
}
