package com.clima.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clima.application.entities.LeituraClimatica;
import com.clima.application.repositories.LeituraClimaticaRepository;

@Service
public class LeituraClimaticaService {

	@Autowired
	private LeituraClimaticaRepository repository;

	public List<LeituraClimatica> listarTodas() {
		return repository.findAll();
	}

	public Optional<LeituraClimatica> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public LeituraClimatica salvar(LeituraClimatica leitura) {
		return repository.save(leitura);
	}

	public LeituraClimatica atualizar(Long id, LeituraClimatica leituraAtualizada) {
		Optional<LeituraClimatica> existente = repository.findById(id);

		if (existente.isPresent()) {
			LeituraClimatica leitura = existente.get();
			leitura.setTemperatura(leituraAtualizada.getTemperatura());
			leitura.setUmidade(leituraAtualizada.getUmidade());
			leitura.setDataHoraLeitura(leituraAtualizada.getDataHoraLeitura());
			return repository.save(leitura);
		}

		throw new RuntimeException("Leitura não encontrada para atualização com o ID: " + id);
	}

	public void deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("Leitura não encontrada com o ID: " + id);
		}
		repository.deleteById(id);
	}

}