package br.com.rsds.sigame.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsds.sigame.model.Sigame;
import br.com.rsds.sigame.repository.SigaMeRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/sigaMe")
@AllArgsConstructor
@Validated
public class SigaMeController {
	SigaMeRepository sigaMeRepository;

	@GetMapping
	public @ResponseBody List<Sigame> list() {
		return sigaMeRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sigame> FindById(@PathVariable @NotNull @Positive Long id) {
		return sigaMeRepository.findById(id).map(recordFound -> ResponseEntity.ok(recordFound))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Sigame create(@RequestBody @Valid Sigame record) {
		return sigaMeRepository.save(record);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Sigame> Update(@PathVariable @NotNull @Positive Long id, @RequestBody Sigame record) {
		return sigaMeRepository.findById(id).map(recordFound -> {
			recordFound.setNome(record.getNome());
			recordFound.setTipo(record.getTipo());
			recordFound.setCategoria(record.getCategoria());
			recordFound.setStatus(record.getStatus());
			recordFound.setRamal(record.getRamal());
			recordFound.setDestino(record.getDestino());
			return ResponseEntity.ok(sigaMeRepository.save(recordFound));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable @NotNull @Positive Long id) {
		return sigaMeRepository.findById(id).map(recordFound -> {
			sigaMeRepository.deleteById(id);
			return ResponseEntity.noContent().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
