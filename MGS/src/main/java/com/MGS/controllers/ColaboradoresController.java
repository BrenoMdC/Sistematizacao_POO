package com.MGS.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MGS.dtos.MGSDto;
import com.MGS.models.MGSModel;
import com.MGS.repositories.MGSColaboradores;


import jakarta.validation.Valid;

@RestController
public class ColaboradoresController {
	
	@Autowired
	MGSColaboradores msgColaboradores;
	
	@GetMapping("/colaboradores")
	public ResponseEntity<List<MGSModel>> listar(){
		List<MGSModel> colaboradoresList = msgColaboradores.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(colaboradoresList);
	}
	
	@PostMapping("/colaboradores")
	public ResponseEntity<MGSModel> salvar(@RequestBody @Valid MGSDto MGSDto){
		var MGSModel = new MGSModel();
		BeanUtils.copyProperties(MGSDto, MGSModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(msgColaboradores.save(MGSModel));
	}
	@GetMapping("/colaboradores/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id){
		Optional<MGSModel> colaborador = msgColaboradores.findById(id);
		if(colaborador.isEmpty()) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(colaborador.get());
	}
	@PutMapping("/colaboradores/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value="id") Integer id, @RequestBody @Valid MGSDto MGSDto){
		Optional<MGSModel> colaborador = msgColaboradores.findById(id);
		if(colaborador.isEmpty()) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado");
		}
		var MGSModel = colaborador.get();
		BeanUtils.copyProperties(MGSDto, MGSModel);
		return ResponseEntity.status(HttpStatus.OK).body(msgColaboradores.save(MGSModel));
	}
	@DeleteMapping("/colaboradores/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value="id") Integer id, @RequestBody @Valid MGSDto MGSDto){
		Optional<MGSModel> colaborador = msgColaboradores.findById(id);
		if(colaborador.isEmpty()) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado");
		}
		msgColaboradores.delete(colaborador.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cadastro excluído com sucesso");
	}
}
