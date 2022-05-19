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

import br.com.nava.entities.VacinaEntity;
import br.com.nava.service.VacinaService;
import br.com.nava.dto.VacinaDTO;

@RestController
@RequestMapping(value = "vacina")
@CrossOrigin("*")
public class VacinaController {
	

	private ArrayList<VacinaEntity> listaVacina = new ArrayList<>();
	private int contador = 0;
	
	
	@Autowired
	private VacinaService vacinaService;

	@GetMapping
	public ResponseEntity<List<VacinaDTO>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(vacinaService.getAll());
	}
	
	@GetMapping("{idVacina}")
	public ResponseEntity<VacinaDTO> getOne(@PathVariable int idVacina) {
		return ResponseEntity.status(HttpStatus.OK).body(vacinaService.getOne(idVacina));
	}
	
    @PostMapping("")
	public ResponseEntity<VacinaDTO> save(@Valid @RequestBody VacinaDTO vacina) {
		
		return ResponseEntity.status(HttpStatus.OK).body(vacinaService.save(vacina.toEntity()));
	}
	
	@PatchMapping("{idVacina")
	public ResponseEntity<VacinaDTO> update(@PathVariable int idVacina,@RequestBody VacinaDTO vacina) {
		return ResponseEntity.status(HttpStatus.OK).body(vacinaService.update(idVacina, vacina.toEntity()));
	}
	
	@DeleteMapping("{idVacina}")
	public void delete(@PathVariable int idVacina) {
		vacinaService.delete(idVacina);
	}
	
	

}
