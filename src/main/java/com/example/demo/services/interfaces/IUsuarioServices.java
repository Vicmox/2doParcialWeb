
package com.example.demo.services.interfaces;

import com.example.demo.dto.UsuarioDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioServices {

    List<UsuarioDto> findAll();

    UsuarioDto findByEmail(String email);

    UsuarioDto findById(int id);

    void save(UsuarioDto usuario);

    void saveAll(List<UsuarioDto> usuario);

    void deleteById(int id);

    void deleteAll(List<UsuarioDto> usuario);

}
