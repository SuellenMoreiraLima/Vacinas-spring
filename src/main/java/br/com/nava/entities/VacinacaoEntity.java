package br.com.nava.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import br.com.nava.dto.VacinacaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VacinacaoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVacinacao;
	private String usuario;
	private String vacina;
	private String dataAplicacao;
	private int numeroDaDose;
	private String dataProximaAplicacao;

	
	public VacinacaoDTO toDTO() {
		ModelMapper mapper = new ModelMapper();
		
		VacinacaoDTO dto = mapper.map(this, VacinacaoDTO.class);
		
		return dto;
	}
	
}
