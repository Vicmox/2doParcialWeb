package com.example.demo.services.implement;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.entities.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.services.interfaces.IUsuarioServices;
import com.example.demo.utilities.Helpers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class UsuarioImplement implements IUsuarioServices {

    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDto> findAll() {

        List<UsuarioDto> dto = new ArrayList<>();
        Iterable<Usuario> usuario = this.usuarioRepository.findAll();

        for (Usuario user : usuario) {

            UsuarioDto usuarioDTO = Helpers.modelMapper().map(user, UsuarioDto.class);
            dto.add(usuarioDTO);

        }

        return dto;
    }

    @Override
    public UsuarioDto findByEmail(String email) {

        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(email);

        if (!usuario.isPresent()) {
            return null;
        }
        return Helpers.modelMapper().map(usuario.get(), UsuarioDto.class);
    }

    @Override
    public UsuarioDto findById(int id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);

        if (!usuario.isPresent()) {
            return null;
        }
        return Helpers.modelMapper().map(usuario.get(), UsuarioDto.class);
    }

    @Override
    public void save(UsuarioDto usuario) {
        Usuario usuarios = Helpers.modelMapper().map(usuario, Usuario.class);

        this.usuarioRepository.save(usuarios);
    }

    @Override
    public void saveAll(List<UsuarioDto> usuario) {

        List<Usuario> auxUsuario = new ArrayList();
        for (UsuarioDto user : usuario) {
            Usuario us = Helpers.modelMapper().map(usuario, Usuario.class);
            auxUsuario.add(us);
        }
        this.usuarioRepository.saveAll(auxUsuario);
    }

    @Override
    public void deleteById(int id) {

        this.usuarioRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<UsuarioDto> usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private UsuarioDto convertToUsuarioDTO(final Usuario usuario) {

        return Helpers.modelMapper().map(usuario, UsuarioDto.class);
    }

}
