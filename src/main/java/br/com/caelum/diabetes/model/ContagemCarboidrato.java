package br.com.caelum.diabetes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ContagemCarboidrato {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@OneToOne
	Horario horario;
	
	double totalInsulina;
	
	@OneToMany
	List<Alimento> alimentos;
}
