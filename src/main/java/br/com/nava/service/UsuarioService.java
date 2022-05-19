package br.com.nava.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.dto.UsuarioDTO;
import br.com.nava.entities.UsuarioEntity;
import br.com.nava.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<UsuarioDTO> getAll(){
		List<UsuarioEntity> lista =  usuarioRepository.findAll();
		
		List<UsuarioDTO> listaDTO = new ArrayList<>();
		for (UsuarioEntity usuarioEntity : lista) {	
			listaDTO.add(usuarioEntity.toDTO() );
		}
		
		return listaDTO;		
	}
	
     public UsuarioDTO getOne(int id) {
		
		Optional<UsuarioEntity> optional = usuarioRepository.findById(id);
		
		UsuarioEntity professor = optional.orElse( new UsuarioEntity() );
		
		return professor.toDTO();
	}
	

	
	
	
	public UsuarioDTO save(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario).toDTO();
	}
	
	
	
	
	public UsuarioDTO update(int idUsuario, UsuarioEntity usuario) {
		Optional<UsuarioEntity> optional = usuarioRepository.findById(idUsuario);
		
		
		if(optional.isPresent() == true ){
			UsuarioEntity usuarioBd = optional.get();
			usuarioBd.setNome(usuario.getNome());
			usuarioBd.setCpf(usuario.getCpf());
			usuarioBd.setDataNascimento(usuario.getDataNascimento());
			usuarioBd.setEndereco(usuario.getEndereco());
			usuarioBd.setTelefone(usuario.getTelefone());
			
			return usuarioRepository.save(usuarioBd).toDTO();
		}
		else {
			return new UsuarioEntity().toDTO();
		}
	}

	public void delete(int idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}
	

}
