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
import br.com.rsds.sigame.service.SigaMeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/api/sigaMe")
@Validated
public class SigaMeController {
	private final SigaMeService sigaMeService;

	public SigaMeController(SigaMeService sigaMeService) {
		this.sigaMeService = sigaMeService;
	}

	@GetMapping
	public @ResponseBody List<Sigame> list() {
		return sigaMeService.list();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sigame> FindById(@PathVariable @NotNull @Positive Long id) {
		return sigaMeService.FindById(id).map(recordFound -> ResponseEntity.ok(recordFound))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Sigame create(@RequestBody @Valid Sigame record) {
		return sigaMeService.create(record);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Sigame> Update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Sigame record) {
		return sigaMeService.Update(id, record).map(recordFound -> {
			return ResponseEntity.ok(recordFound);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable @NotNull @Positive Long id) {
		if (sigaMeService.Delete(id)) {
			return ResponseEntity.noContent().<Void>build();
		}
		return ResponseEntity.notFound().build();
	}

}
