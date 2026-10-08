package com.sigep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.sigep.model.Usuario;
import com.sigep.repository.IUsuarioRepository;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUsuarioRepository repoUsu;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Endpoint temporal para cifrar claves
    @GetMapping("/init")
    public String inicializar() {
        Usuario admin = repoUsu.findByUsuario("admin");
        if (admin != null) {
            admin.setClave(passwordEncoder.encode("123456"));
            repoUsu.save(admin);
        }

        Usuario operativo = repoUsu.findByUsuario("operativo");
        if (operativo != null) {
            operativo.setClave(passwordEncoder.encode("123456"));
            repoUsu.save(operativo);
        }

        return "Claves cifradas correctamente con BCrypt";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String usuario = credenciales.get("usuario");
        String clave   = credenciales.get("clave");

        Usuario usu = repoUsu.findByUsuario(usuario);

        if (usu != null && passwordEncoder.matches(clave, usu.getClave())) {
            return ResponseEntity.ok(Map.of(
                "mensaje", "Login exitoso",
                "nombre",  usu.getNombre(),
                "usuario", usu.getUsuario()
            ));
        } else {
            return ResponseEntity.status(401)
                   .body(Map.of("mensaje", "Credenciales incorrectas"));
        }
    }
}