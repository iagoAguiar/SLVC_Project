package br.com.zup.slvc.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zup.slvc.config.ErroDeValidacaoHandler;
import br.com.zup.slvc.modelo.CadAplicacaoVacinas;
import br.com.zup.slvc.modelo.Usuario;
import br.com.zup.slvc.repository.CadastroVacRepository;
import br.com.zup.slvc.repository.UsuariosRepository;

public class CadAplicacaoVacinasForm {
	
	@NotNull @NotEmpty
	private  String nomeVacina;
	@NotNull  
	private Usuario usuario_id;
	@NotNull @NotEmpty
	private String dataVacinacao;
	
	
	public String getNomeVacina() {
		return nomeVacina;
	}
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	public  Usuario getUsuario() {
		return usuario_id;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario_id = usuario;
	}
	public String getDataVacinacao() {
		return dataVacinacao;
	}
	public void setDataVacinacao(String dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	
	
	
	public  CadAplicacaoVacinas converter(CadastroVacRepository cadastroVacRepository, 
			UsuariosRepository usuariosRepository) {
		
		Optional<Usuario> usuarioopt = usuariosRepository.findById(usuario_id.getId());
		
		if(usuarioopt.isPresent()) {
			Usuario usuario = usuarioopt.get();			
			return new CadAplicacaoVacinas(nomeVacina, usuario, dataVacinacao);
		}
		else {
			return null;
		}		
	}
	
	
	
	
	
	


}
