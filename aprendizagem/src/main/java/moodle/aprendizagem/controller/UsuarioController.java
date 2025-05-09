package moodle.aprendizagem.controller;

import moodle.aprendizagem.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import moodle.aprendizagem.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projeto/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET /projeto/v1/usuarios
    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    // GET /projeto/v1/usuarios/{id}
    @GetMapping("/{id}")
    public Optional<Usuario> findById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    // POST /projeto/v1/usuarios
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    // PUT /projeto/v1/usuarios/{id}
    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.update(id, usuario);
    }

    // DELETE /projeto/v1/usuarios/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }
}
