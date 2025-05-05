package service;

import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar todos os usuários
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Buscar por ID
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Criar novo usuário
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Atualizar
    public Usuario update(Long id, Usuario usuarioAtualizado) {
        if (usuarioRepository.existsById(id)) {
            usuarioAtualizado.setId(id);
            return usuarioRepository.save(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    // Deletar
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
