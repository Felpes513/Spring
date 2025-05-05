package controller;

import model.Usuario;
import service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET /usuarios
    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    // GET /usuarios/{id}
    @GetMapping("/{id}")
    public Optional<Usuario> findById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    // POST /usuarios
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    // PUT /usuarios/{id}
    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.update(id, usuario);
    }

    // DELETE /usuarios/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }
}
