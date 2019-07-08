package br.ufsc.ine5646.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufsc.ine5646.entity.Medico;
import br.ufsc.ine5646.entity.Paciente;
import br.ufsc.ine5646.exceptions.MedicoNotFoundException;
import br.ufsc.ine5646.repository.MedicoRepository;

@RestController
public class MedicoController {

	private final MedicoRepository repository;

	MedicoController(MedicoRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/medicos")
	List<Medico> findAll() {
		return repository.findAll();
	}

	
	@PostMapping("/medicos")
	Medico novoMedico(@RequestBody Medico novoMedico) {
		return repository.save(novoMedico);
	}

	@GetMapping("/medicos/{id}")
	Medico acharMedico(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new MedicoNotFoundException(id));

	}

	@PutMapping("/medicos/{id}")
	Medico editarMedico(@RequestBody Medico novoMedico, @PathVariable Long id) {

		return repository.findById(id).map(medico -> {
			medico.setNome(novoMedico.getNome());
			medico.setEmail(novoMedico.getEmail());
			medico.setTelefone(novoMedico.getTelefone());
			return repository.save(medico);
		}).orElseGet(() -> {
			novoMedico.setId(id);
			return repository.save(novoMedico);
		});
	}

	@DeleteMapping("/medicos/{id}")
	void deletaMedico(@PathVariable Long id) {
		repository.deleteById(id);
	}

	
	

}