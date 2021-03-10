package br.com.zup.slvc.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zup.slvc.modelo.Usuario;
import br.com.zup.slvc.repository.UsuariosRepository;

public class UsuarioForm {

	
	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	@NotNull @NotEmpty @Length(min = 10)
	private String cpf;
	@NotNull @NotEmpty 
	private String email;
	@NotNull @NotEmpty 
	private String dataNascimento;
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Usuario converter(UsuariosRepository usuariosRepository) {
		return new Usuario( nome, cpf, email, dataNascimento);
		
	}
	
	
	

}
