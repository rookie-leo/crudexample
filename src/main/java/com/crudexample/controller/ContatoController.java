package com.crudexample.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudexample.models.Contato;
import com.crudexample.repository.ContatoRepository;

@RestController
@RequestMapping({"/contatos"})
public class ContatoController {

	private ContatoRepository cr;
	
	ContatoController(ContatoRepository contatoRepositoy){
		this.cr = contatoRepositoy;
	}
	
	@GetMapping
	public List findAll() {
		/*Esse método retorna todos contatos*/
		return cr.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable long id) {
		/*Esse método retorna um contato especifico*/
		return cr.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Contato create(@RequestBody Contato contato) {
		/*Esse método cria um novo contato*/
		return cr.save(contato);
	}
	
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Contato contato) {
		/*Esse método irá alterar apenas um contato especifico*/
		return cr.findById(id)
				.map(record -> {
					record.setNome(contato.getNome());
					record.setEmail(contato.getEmail());
					record.setFone(contato.getFone());
					Contato updated = cr.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	/*DELETE*/
}
