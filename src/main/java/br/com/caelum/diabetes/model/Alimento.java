package br.com.caelum.diabetes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Alimento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@NotEmpty
	String nome;
	
	@NotEmpty
	double carboidrato;
}
