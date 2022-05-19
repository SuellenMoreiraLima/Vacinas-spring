package br.com.nava.dto;

import org.modelmapper.ModelMapper;

import br.com.nava.entities.VacinacaoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacinacaoDTO {
	
	private int idVacinacao;
    private String usuario;
	private String vacina;
	private String dataAplicacao;
	private int numeroDaDose;
	private String dataProximaAplicacao;
	
public VacinacaoEntity toEntity() {
		
		ModelMapper mapper = new ModelMapper();
		
		return mapper.map(this, VacinacaoEntity.class);
	}

}
