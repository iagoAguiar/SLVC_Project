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

import br.com.zup.slvc.controller.dot.CadAplicacaoVacinasDTO;
import br.com.zup.slvc.controller.form.CadAplicacaoVacinasForm;
import br.com.zup.slvc.modelo.CadAplicacaoVacinas;
import br.com.zup.slvc.repository.CadastroVacRepository;

@Controller @RestController @RequestMapping("/cadastro")
public class CadAplicacaoVacinasController {
	
	
	@Autowired
	private CadastroVacRepository cadastroVacRepository;
	

	
	@GetMapping
	public List<CadAplicacaoVacinasDTO> lista(){
		List<CadAplicacaoVacinasDTO> cadAplicacaoVacinasDTO = CadAplicacaoVacinasDTO.converter(cadastroVacRepository.findAll());
		
		return cadAplicacaoVacinasDTO;
	}
	
	@PostMapping 	@Transactional
	public ResponseEntity<CadAplicacaoVacinasDTO> cadastrar(@RequestBody @Valid CadAplicacaoVacinasForm cadAplicacaoVacinasForm, UriComponentsBuilder uriBuilder) {
		
		CadAplicacaoVacinas cadAplicacaoVacina = cadAplicacaoVacinasForm.converter(cadastroVacRepository);
			
			cadastroVacRepository.save(cadAplicacaoVacina);
			
			URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(cadAplicacaoVacina.getId()).toUri();
			
		
				return ResponseEntity.created(uri).body(new CadAplicacaoVacinasDTO(cadAplicacaoVacina));
				
				
			
		
	}
	
	
	
	
}
