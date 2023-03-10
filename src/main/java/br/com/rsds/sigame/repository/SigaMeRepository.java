package br.com.rsds.sigame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rsds.sigame.model.Sigame;

@Repository
public interface SigaMeRepository extends JpaRepository<Sigame, Long> {

}
