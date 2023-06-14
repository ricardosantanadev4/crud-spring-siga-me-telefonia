package br.com.rsds.sigame.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rsds.sigame.dto.SigaMeDTO;
import br.com.rsds.sigame.dto.mapper.SigaMeMapper;
import br.com.rsds.sigame.exception.RecordNotFoundException;
import br.com.rsds.sigame.repository.SigaMeRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
@Validated
public class SigaMeService {
	private final SigaMeRepository sigaMeRepository;
	private final SigaMeMapper sigaMeMapper;

	public SigaMeService(SigaMeRepository sigaMeRepository, SigaMeMapper sigaMeMapper) {
		this.sigaMeRepository = sigaMeRepository;
		this.sigaMeMapper = sigaMeMapper;
	}

	public List<SigaMeDTO> list() {
		return sigaMeRepository.findAll().stream().map(sigaMeMapper::toDO).collect(Collectors.toList());
	}

	public SigaMeDTO FindById(@PathVariable @NotNull @Positive Long id) {
		return sigaMeRepository.findById(id).map(sigaMeMapper::toDO).orElseThrow(() -> new RecordNotFoundException(id));
	}

	public SigaMeDTO create(@Valid @NotNull SigaMeDTO record) {
		return sigaMeMapper.toDO(sigaMeRepository.save(sigaMeMapper.toEntity(record)));
	}

	public SigaMeDTO Update(@NotNull @Positive Long id, @RequestBody @Valid @NotNull SigaMeDTO record) {
		return sigaMeRepository.findById(id).map(recordFound -> {
			recordFound.setName(record.name());
			recordFound.setType(sigaMeMapper.convertTypeValue(record.type()));
			recordFound.setCategory(sigaMeMapper.convertCategoryValue(record.category()));
			recordFound.setStatus(sigaMeMapper.convertStatusValue(record.status()));
			recordFound.setRamal(record.ramal());
			recordFound.setDestiny(record.destiny());
			return sigaMeMapper.toDO(sigaMeRepository.save(recordFound));
		}).orElseThrow(() -> new RecordNotFoundException(id));
	}

	public void Delete(@PathVariable @NotNull @Positive Long id) {
		sigaMeRepository.delete(sigaMeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
	}
}
