package br.com.zup.slvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.zup.slvc.modelo.Usuario;



public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

	Usuario findByNome(String nome);

}
