package br.com.nava.controllers;

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
import br.com.nava.dto.UsuarioDTO;
import br.com.nava.entities.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;
import br.com.nava.service.UsuarioService;

@RestController
@RequestMapping(value = "usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	private ArrayList<UsuarioEntity> listaUsuario = new ArrayList<>();
	private int contador = 0;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping()
	public ResponseEntity<List<UsuarioDTO>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAll());
	}
	@GetMapping("{idUsuario}")
	public ResponseEntity<UsuarioDTO> getOne(@PathVariable int idUsuario) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getOne(idUsuario));
	}
	
    @PostMapping()
	public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO usuario) {
		
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario.toEntity()));
	}
	
	@PatchMapping("{idUsuario}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable int idUsuario,@RequestBody UsuarioDTO usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(idUsuario, usuario.toEntity()));
	}
	
	@DeleteMapping("{idUsuario}")
	public void delete(@PathVariable int idUsuario) {
		usuarioService.delete(idUsuario);
	}

}
