package br.ufsc.ine5646.exceptions;

public class MedicoNotFoundException extends RuntimeException {
	public MedicoNotFoundException(Long id) {
		super("Não foi possível achar o médico: " + id);
	}
}
