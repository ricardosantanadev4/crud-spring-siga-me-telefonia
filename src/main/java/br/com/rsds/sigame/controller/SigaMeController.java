package br.com.rsds.sigame.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsds.sigame.model.Sigame;
import br.com.rsds.sigame.repository.SigaMeRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/sigaMe")
@AllArgsConstructor
public class SigaMeController {
	SigaMeRepository sigaMeRepository;

	public List<Sigame> list() {
		List<Sigame> sigameList = sigaMeRepository.findAll();
		return sigameList;
	}
}
