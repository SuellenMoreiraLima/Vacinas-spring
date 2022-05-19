package br.com.nava.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.nava.entities.VacinacaoEntity;

@Repository
public interface VacinacaoRepository extends JpaRepository<VacinacaoEntity, Integer>{


}
