package br.com.nava.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.modelmapper.ModelMapper;

import br.com.nava.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@NotEmpty(message = "O campo não pode ser vazio")
	private String nome;
	
	@NotEmpty(message = "O campo não pode ser vazio")
	private String cpf;
	
	@NotEmpty(message = "O campo não pode ser vazio")
	private String dataNascimento;
	
	@NotEmpty(message = "O campo não pode ser vazio")
	private String endereco;
	
	@NotEmpty(message = "O campo não pode ser vazio")
	private String telefone;
	
	public UsuarioDTO toDTO() {
		ModelMapper mapper = new ModelMapper();
		
		UsuarioDTO dto = mapper.map(this, UsuarioDTO.class);
		
		return dto;
	}

}
