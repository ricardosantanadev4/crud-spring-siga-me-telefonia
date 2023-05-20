package br.com.rsds.sigame.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import br.com.rsds.sigame.dto.SigaMeDTO;
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
	public @ResponseBody List<SigaMeDTO> list() {
		return sigaMeService.list();
	}

	@GetMapping("/{id}")
	public SigaMeDTO FindById(@PathVariable @NotNull @Positive Long id) {
		return sigaMeService.FindById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public SigaMeDTO create(@RequestBody @Valid @NotNull SigaMeDTO record) {
		return sigaMeService.create(record);
	}

	@PutMapping("/{id}")
	public SigaMeDTO Update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid SigaMeDTO record) {
		return sigaMeService.Update(id, record);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void Delete(@PathVariable @NotNull @Positive Long id) {
		sigaMeService.Delete(id);
	}

}
