package com.crudexample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor// cria automaticamente um construtor com todas os atributos da classe como argumento.
@NoArgsConstructor//cria automaticamente um construtor vazio (sem argumentos).
@Data//cria automaticamente os métodos toString, equals, hashCode, getters e setters.
@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private String fone;
}
