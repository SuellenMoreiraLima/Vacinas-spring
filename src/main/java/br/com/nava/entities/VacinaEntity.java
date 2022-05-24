package br.com.nava.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.modelmapper.ModelMapper;

import br.com.nava.dto.VacinaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VacinaEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVacina;

	@NotEmpty(message = "O campo não pode ser vazio")
	private String nomeVacina;
	@NotEmpty(message = "O campo não pode ser vazio")
	private String fabricante;
	@NotEmpty(message = "O campo não pode ser vazio")
	private int dosesNecessarias;
	@NotEmpty(message = "O campo não pode ser vazio")
	private int intervaloDeDiasEntreDoses; 
	
	
	public VacinaDTO toDTO() {
		ModelMapper mapper = new ModelMapper();
		
		VacinaDTO dto = mapper.map(this, VacinaDTO.class);
		
		return dto;
	}
}
