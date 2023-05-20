package br.com.rsds.sigame.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.rsds.sigame.dto.SigaMeDTO;
import br.com.rsds.sigame.model.Sigame;

@Component
public class SigaMeMapper {

	public SigaMeDTO toDO(Sigame sigame) {
		if (sigame == null) {
			return null;
		}

		return new SigaMeDTO(sigame.getId(), sigame.getNome(), sigame.getTipo(), sigame.getCategoria(),
				sigame.getStatus(), sigame.getRamal(), sigame.getDestino());
	}

	public Sigame toEntity(SigaMeDTO sigaMeDTO) {
		if (sigaMeDTO == null) {
			return null;
		}

		Sigame sigame = new Sigame();

		if (sigaMeDTO.id() != null) {
			sigame.setId(sigaMeDTO.id());
		}

		sigame.setNome(sigaMeDTO.nome());
		sigame.setTipo(sigaMeDTO.tipo());
		sigame.setCategoria(sigaMeDTO.categoria());
		sigame.setStatus(sigaMeDTO.status());
		sigame.setRamal(sigaMeDTO.ramal());
		sigame.setDestino(sigaMeDTO.destino());
		return sigame;
	}
}
