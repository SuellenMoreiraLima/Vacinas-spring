package br.com.nava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.dto.VacinacaoDTO;
import br.com.nava.entities.VacinacaoEntity;
import br.com.nava.repositories.VacinacaoRepository;

@Service
public class VacinacaoService {
	
	@Autowired
	private VacinacaoRepository vacinacaoRepository;

	
	public List<VacinacaoDTO> getAll(){
		List<VacinacaoEntity> lista =  vacinacaoRepository.findAll();
		
		List<VacinacaoDTO> listaDTO = new ArrayList<>();
		

		
		for (VacinacaoEntity vacinacaoEntity : lista) {						
			
			listaDTO.add( vacinacaoEntity.toDTO() );
		}
		
		return listaDTO;		
	}
	
	
	public VacinacaoDTO getOne(int idVacinacao) {
		
		Optional<VacinacaoEntity> optional = vacinacaoRepository.findById(idVacinacao);
		
		VacinacaoEntity vacinacao = optional.orElse( new VacinacaoEntity() );
		
		return vacinacao.toDTO();
	}
	
	public VacinacaoDTO save(VacinacaoEntity vacinacao) {
		return vacinacaoRepository.save(vacinacao).toDTO();
	}
	
	
	public VacinacaoDTO update(int idVacinacao, VacinacaoEntity vacinacao) {
	

		Optional<VacinacaoEntity> optional = vacinacaoRepository.findById(idVacinacao);

		if (optional.isPresent() == true) {

			VacinacaoEntity vacinaBD = optional.get();
			vacinaBD.setUsuario( vacinacao.getUsuario() );
			vacinaBD.setVacina( vacinacao.getVacina() );
			vacinaBD.setDataAplicacao( vacinacao.getDataAplicacao() );
			vacinaBD.setNumeroDaDose( vacinacao.getNumeroDaDose() );
			vacinaBD.setDataProximaAplicacao( vacinacao.getDataProximaAplicacao() );
			
			return vacinacaoRepository.save(vacinaBD).toDTO();
		}

		else {
			return new VacinacaoEntity().toDTO();
		}
	}
	
	
	public void delete(int idVacinacao) {
		
		vacinacaoRepository.deleteById(idVacinacao);

		
	}
	
}
