package br.com.zup.slvc.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.slvc.controller.dot.UsuarioDTO;
import br.com.zup.slvc.controller.form.UsuarioForm;
import br.com.zup.slvc.modelo.Usuario;
import br.com.zup.slvc.repository.UsuariosRepository;

@Controller @RestController @RequestMapping("/usuarios")
public class UsuariosController {
	
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	

	
	@GetMapping
	public List<UsuarioDTO> lista(){
		List<UsuarioDTO> usuarioDTO = UsuarioDTO.converter(usuariosRepository.findAll());
		return usuarioDTO;
	}
	
	@PostMapping 	@Transactional
	public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder) {
		
			Usuario usuario = usuarioForm.converter(usuariosRepository);
			
			usuariosRepository.save(usuario);
			
			URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
			
		
				return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
				
				
			
		
	}
	
	
	
	
}
