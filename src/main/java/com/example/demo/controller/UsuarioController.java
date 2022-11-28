package com.example.demo.controller;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.entities.Usuario;
import com.example.demo.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getUsuarioAll() {

        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuariobyId(@PathVariable Integer id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            return usuario.get();
        }

        return null;

    }

    @GetMapping("/{username}")
    public Usuario getUsuariobyUsername(@PathVariable String username) {

        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);

        if (usuario.isPresent()) {
            return usuario.get();
        }

        return null;

    }

    @PostMapping
    public Usuario postUsuarios(@RequestBody Usuario usuario) {

        usuarioRepository.save(usuario);

        return usuario;

    }

    @PutMapping("/{id}")
    public Usuario putUsuariobyId(@PathVariable Integer id, @RequestBody Usuario usuario) {

        Optional<Usuario> usuarioCurrent = usuarioRepository.findById(id);

        if (usuarioCurrent.isPresent()) {

            Usuario usuarioReturn = usuarioCurrent.get();

            usuarioReturn.setApellido(usuario.getApellido());
            usuarioReturn.setNombre(usuario.getNombre());
            usuarioReturn.setEmail(usuario.getEmail());

            usuarioRepository.save(usuarioReturn);

            return usuarioReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Usuario deleteUsuariobyId(@PathVariable Integer id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {

            Usuario usuarioReturn = usuario.get();

            usuarioRepository.deleteById(id);

            return usuarioReturn;
        }

        return null;

    }
}
