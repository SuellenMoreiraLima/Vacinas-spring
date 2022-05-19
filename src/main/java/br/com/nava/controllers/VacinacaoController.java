package br.com.nava.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nava.dto.VacinacaoDTO;
import br.com.nava.entities.VacinacaoEntity;
import br.com.nava.repositories.VacinacaoRepository;
import br.com.nava.service.VacinacaoService;

@RestController
@RequestMapping(value = "vacinacao")
@CrossOrigin("*")
public class VacinacaoController {

	private ArrayList<VacinacaoEntity> listaProfessor = new ArrayList<>();
	private int contador = 0;
	
	@Autowired
	private VacinacaoService vacinacaoService;
	
	
	@GetMapping()
	public ResponseEntity<List<VacinacaoDTO>> getAll(){

		return ResponseEntity.status(HttpStatus.OK).body(vacinacaoService.getAll());
	}
	
	@GetMapping("{idVacinacao}")
	public ResponseEntity<VacinacaoDTO> getOne(@PathVariable int idVacinacao) {

		return ResponseEntity.status(HttpStatus.OK).body(vacinacaoService.getOne(idVacinacao));
	}
	
	@PostMapping()
	public ResponseEntity<VacinacaoDTO> save(@Valid @RequestBody VacinacaoDTO vacinacao) {
		

		return ResponseEntity.status(HttpStatus.OK).body(vacinacaoService.save(vacinacao.toEntity()));
	}
	
	@PatchMapping("{idVacinacao}")
	public ResponseEntity<VacinacaoDTO> update(@PathVariable int idVacinacao, 
			@RequestBody VacinacaoDTO vacinacao) {

		return ResponseEntity.status(HttpStatus.OK).body(vacinacaoService.update(idVacinacao, vacinacao.toEntity()));
	}
	
	@DeleteMapping("{idVacinacao}")
	public void delete(@PathVariable int idVacinacao) {

		vacinacaoService.delete(idVacinacao);
	}


}

	






