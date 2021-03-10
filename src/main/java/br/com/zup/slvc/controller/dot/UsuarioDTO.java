package br.com.zup.slvc.controller.dot;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.slvc.modelo.Usuario;

public class UsuarioDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String data;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.data = usuario.getDataNascimento();
		this.email = usuario.getEmail();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	public static List<UsuarioDTO> converter(List<Usuario> usuarios) {
		
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
		
	}
	
	//  nome,cpf,email,data
	
}
