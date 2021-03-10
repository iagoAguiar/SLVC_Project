package br.com.zup.slvc.modelo;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;


@Entity
public class CadAplicacaoVacinas {
	@Id 	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nomeVacina;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cadcplicacaovacinas_id")
	private Usuario usuario;

	//@NotEmpty(message = "Data de Vacinacao não pode ser vazia")	 
	private LocalDateTime dataVacinacao;


	@Deprecated    
	public CadAplicacaoVacinas() {
		super();
	}

	public CadAplicacaoVacinas( String nomeVacina, Usuario usuario) {
		super();
		this.nomeVacina = nomeVacina;
		this.usuario = usuario;
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

	public LocalDateTime getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(LocalDateTime dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

	public Long getId() {
		return id;
	}

	
	
}
