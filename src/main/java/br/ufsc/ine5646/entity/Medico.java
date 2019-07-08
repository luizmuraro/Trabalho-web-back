package br.ufsc.ine5646.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="MEDICO")
public class Medico {

	public Medico() {

	}	
	
	private @Id @GeneratedValue Long id;
	private String nome;
	private String email;
	private long telefone;
	private ArrayList<Paciente> pacientes;
	
	public Medico(String nome, String email, long telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}



	
}
