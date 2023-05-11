package br.com.rsds.sigame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rsds.sigame.model.Sigame;
import br.com.rsds.sigame.repository.SigaMeRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
@Validated
public class SigaMeService {
	private final SigaMeRepository sigaMeRepository;

	public SigaMeService(SigaMeRepository sigaMeRepository) {
		this.sigaMeRepository = sigaMeRepository;
	}

	@GetMapping
	public List<Sigame> list() {
		return sigaMeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Sigame> FindById(@PathVariable @NotNull @Positive Long id) {
		return sigaMeRepository.findById(id);
	}

	@PostMapping
	public Sigame create(@Valid Sigame record) {
		return sigaMeRepository.save(record);
	}

	@PutMapping("/{id}")
	public Optional<Sigame> Update(@NotNull @Positive Long id, @RequestBody @Valid Sigame record) {
		return sigaMeRepository.findById(id).map(recordFound -> {
			recordFound.setNome(record.getNome());
			recordFound.setTipo(record.getTipo());
			recordFound.setCategoria(record.getCategoria());
			recordFound.setStatus(record.getStatus());
			recordFound.setRamal(record.getRamal());
			recordFound.setDestino(record.getDestino());
			return sigaMeRepository.save(recordFound);
		});
	}

	@DeleteMapping("/{id}")
	public boolean Delete(@PathVariable @NotNull @Positive Long id) {
		return sigaMeRepository.findById(id).map(recordFound -> {
			sigaMeRepository.deleteById(id);
			return true;
		}).orElse(false);
	}
}
