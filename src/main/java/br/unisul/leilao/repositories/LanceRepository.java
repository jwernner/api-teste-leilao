package br.unisul.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.leilao.model.Lance;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Long> {

}
