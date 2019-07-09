package br.ufsc.ine5646.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufsc.ine5646.entity.Medico;
import br.ufsc.ine5646.entity.Paciente;
import br.ufsc.ine5646.exceptions.MedicoNotFoundException;
import br.ufsc.ine5646.repository.PacienteRepository;

@RestController
public class PacienteController {
	
	private final PacienteRepository repository;
	
	public PacienteController(PacienteRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/pacientes")
	public Paciente novoPaciente(@RequestBody Paciente novoPaciente) {
		return repository.save(novoPaciente);
	}
	
	@GetMapping("/pacientes")
	List<Paciente> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/pacientes/{id}")
	Paciente acharPaciente(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new MedicoNotFoundException(id));

	}
	@PutMapping("/pacientes/{id}")
	Paciente editarPaciente(@RequestBody Paciente novoPaciente, @PathVariable Long id) {

		return repository.findById(id).map(paciente -> {
			paciente.setNome(novoPaciente.getNome());
			paciente.setCpf(novoPaciente.getCpf());
			paciente.setEmail(novoPaciente.getEmail());
			paciente.setTelefone(novoPaciente.getTelefone());
			paciente.setAnamnese(novoPaciente.getAnamnese());
			paciente.setDiagnostico(novoPaciente.getDiagnostico());
			paciente.setTratamento(novoPaciente.getTratamento());
			return repository.save(paciente);
		}).orElseGet(() -> {
			novoPaciente.setId(id);
			return repository.save(novoPaciente);
		});
	}

	@DeleteMapping("/pacientes/{id}")
	void deletaPaciente(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
	
}
