package com.clima.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clima.application.entities.LeituraClimatica;
import com.clima.application.services.LeituraClimaticaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/telemetria")
@CrossOrigin("*")
public class LeituraClimaticaController {

	@Autowired
	private LeituraClimaticaService service;

	@PostMapping
	public ResponseEntity<LeituraClimatica> cadastrar(@Valid @RequestBody LeituraClimatica leitura) {
		LeituraClimatica leituraSalva = service.salvar(leitura);
		return ResponseEntity.status(HttpStatus.CREATED).body(leitura);
	}

	@GetMapping
	public ResponseEntity<List<LeituraClimatica>> listarTodas() {
		return ResponseEntity.ok(service.listarTodas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<LeituraClimatica> buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<LeituraClimatica> atualizar(@PathVariable Long id,
			@Valid @RequestBody LeituraClimatica leitura) {

		try {
			LeituraClimatica atualizada = service.atualizar(id, leitura);
			return ResponseEntity.ok(atualizada);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		try {
			service.deletar(id);
			return ResponseEntity.noContent().build();
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
