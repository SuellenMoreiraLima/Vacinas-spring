package br.com.nava.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.nava.dto.VacinaDTO;
import br.com.nava.entities.VacinaEntity;
import br.com.nava.repositories.VacinaRepository;

@Service
public class VacinaService {
	
	@Autowired
	private VacinaRepository vacinaRepository;
	
	public List<VacinaDTO> getAll(){
		List<VacinaEntity> lista =  vacinaRepository.findAll();
		
		List<VacinaDTO> listaDTO = new ArrayList<>();
		for (VacinaEntity vacinaEntity : lista) {						
			listaDTO.add( vacinaEntity.toDTO() );
		}
		return listaDTO;		
	}
	
		
		public VacinaDTO getOne(int idVacina){
			
			Optional<VacinaEntity> optional = vacinaRepository.findById(idVacina);
			
			VacinaEntity vacina = optional.orElse( new VacinaEntity() );
			
			return vacina.toDTO();
		}
		
	
	public VacinaDTO save(VacinaEntity vacina){
		return vacinaRepository.save(vacina).toDTO();
	}
	
	
	
	
	public VacinaDTO update(int idVacina, VacinaEntity vacina) {
		Optional<VacinaEntity> optional = vacinaRepository.findById(idVacina);
		
		
		if(optional.isPresent() == true ) {
			VacinaEntity vacinaBd = optional.get();
			vacinaBd.setNomeVacina(vacina.getNomeVacina());
			vacinaBd.setFabricante(vacina.getFabricante());
			vacinaBd.setDosesNecessarias(vacina.getDosesNecessarias());
			vacinaBd.setIntervaloDeDiasEntreDoses(vacina.getIntervaloDeDiasEntreDoses());
			
			return vacinaRepository.save(vacinaBd).toDTO();

		}
		else {
			return new VacinaEntity().toDTO();
			}
	}

	public void delete(int idVacina) {
		vacinaRepository.deleteById(idVacina);
	}
	
	
}
