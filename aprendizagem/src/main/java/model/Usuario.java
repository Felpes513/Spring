package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario") // Signfica que essa classe será mapeada para a tabela Usuário no banco de dados
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id // Primary Key no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Valor que será gerado automaticamente no banco de dados (Auto_increment)
    private Long id;

    private String nome;

    @Column(unique = true) // Define que essas duas colunas no banco de dados são únicos
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING) //
    private TipoUsuario tipo; //ALUNO, PROFESSOR, SECRETÁRIA, COORDENAÇÃO
}
