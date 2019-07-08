package br.ufsc.ine5646.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufsc.ine5646.entity.Medico;

@Transactional
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {


}
