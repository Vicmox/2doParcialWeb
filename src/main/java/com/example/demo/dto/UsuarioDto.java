
package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UsuarioDto implements Serializable {
    
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private Date fechaCreate;
}
