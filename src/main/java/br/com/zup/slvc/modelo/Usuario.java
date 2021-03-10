package br.com.zup.slvc.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;



@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"cpf", "email"})})
public class Usuario {

	@Id 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;
	
	@Column(unique = true)	
	@NotEmpty(message = "CPF não pode ser vazio")	  
	@CPF(message = "CPF inválido")	
	private String cpf;
	
	@Column(unique = true)	
	@NotEmpty(message = "Email não pode ser vazio")	  @Email
	private String email;
	
	@NotEmpty(message = "Data de nascimento não pode ser vazia")	 
	private String dataNascimento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cadcplicacaovacinas_id")
	private CadAplicacaoVacinas cadAplicacaoVacinas; 

	@Deprecated    
	public Usuario() {
		super();
	}

	public Usuario(String nome, String cpf,String email, String dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}