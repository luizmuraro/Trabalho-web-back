package br.ufsc.ine5646.entity;

import java.io.InputStream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


//@Table(name="PRONTUARIO")
@Entity
public class Prontuario {
	
	private @Id @GeneratedValue Long id;
	private String anamnese;
	private String diagnostico;
	private String tratamento;
//	private InputStream exame;
	
	public Prontuario(String anamnese, String diagnostico, String tratamento) {
		this.anamnese = anamnese;
		this.diagnostico = diagnostico;
		this.tratamento = tratamento;
	}

	public String getAnamnese() {
	return anamnese;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setAnamnese(String anamnese) {
	this.anamnese = anamnese;
	}
	public String getDiagnostico() {
	return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
	this.diagnostico = diagnostico;
	}
	public String getTratamento() {
	return tratamento;
	}
	public void setTratamento(String tratamento) {
	this.tratamento = tratamento;
	}
//	public InputStream getExame() {
//	return exame;
//	}
//	public void setExame(InputStream exame) {
//	this.exame = exame;
//	}
}
