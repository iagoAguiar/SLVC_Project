package br.com.zup.slvc.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zup.slvc.modelo.CadAplicacaoVacinas;
import br.com.zup.slvc.modelo.Usuario;
import br.com.zup.slvc.repository.CadastroVacRepository;

public class CadAplicacaoVacinasForm {
	
	@NotNull @NotEmpty
	private  String nomeVacina;
	//@NotNull @NotEmpty 
	private Usuario usuario;
	//@NotNull @NotEmpty 
	private LocalDateTime dataVacinacao;
	
	
	public String getNomeVacina() {
		return nomeVacina;
	}
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	public  Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public LocalDateTime getDataVacinacao() {
		return dataVacinacao;
	}
	public void setDataVacinacao(LocalDateTime dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	
	
	public  CadAplicacaoVacinas converter(CadastroVacRepository cadastroVacRepository) {
		
		return new CadAplicacaoVacinas(nomeVacina, usuario);
	}
	
	
	
	
	
	


}
