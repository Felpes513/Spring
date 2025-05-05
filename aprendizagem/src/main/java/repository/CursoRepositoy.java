package repository;

import model.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositoy extends CrudRepository<Curso, Integer> {
}
