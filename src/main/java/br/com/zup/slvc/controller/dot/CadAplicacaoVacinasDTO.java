package br.com.zup.slvc.controller.dot;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.slvc.modelo.CadAplicacaoVacinas;
import br.com.zup.slvc.modelo.Usuario;

public class CadAplicacaoVacinasDTO {
	
	
	private Long id;	
	private String nomeVacina;
	private Usuario usuario;
	private String dataVacinacao;
	
	public CadAplicacaoVacinasDTO(CadAplicacaoVacinas cadAplicacaoVacinas) {
		this.id =  cadAplicacaoVacinas.getId();
		this.nomeVacina =  cadAplicacaoVacinas.getNomeVacina();
		this.usuario = cadAplicacaoVacinas.getUsuario();
		this.dataVacinacao = cadAplicacaoVacinas.getDataVacinacao();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(String dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	

	public static List<CadAplicacaoVacinasDTO> converter(List<CadAplicacaoVacinas> cadAplicacaoVacinas) {
		
		return cadAplicacaoVacinas.stream().map(CadAplicacaoVacinasDTO::new).collect(Collectors.toList());
		
	}
	
	
	

}





















