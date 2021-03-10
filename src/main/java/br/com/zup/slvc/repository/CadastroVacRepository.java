package br.com.zup.slvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.slvc.modelo.CadAplicacaoVacinas;



public interface CadastroVacRepository extends JpaRepository<CadAplicacaoVacinas, Long> {


}
