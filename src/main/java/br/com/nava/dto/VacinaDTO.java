package br.com.nava.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.modelmapper.ModelMapper;

import br.com.nava.entities.VacinaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacinaDTO {

	
	private int idVacina;

	private String nomeVacina;
	

	private String fabricante;
	

	private int dosesNecessarias;
	

	private int intervaloDeDiasEntreDoses;
	
	public VacinaEntity toEntity() {
		
		ModelMapper mapper = new ModelMapper();
		
		return mapper.map(this, VacinaEntity.class);
	}
}
