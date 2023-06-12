package br.com.rsds.sigame.dto.mapper;

import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import br.com.rsds.sigame.dto.SigaMeDTO;
import br.com.rsds.sigame.enums.Category;
import br.com.rsds.sigame.enums.Type;
import br.com.rsds.sigame.model.Sigame;

@Component
public class SigaMeMapper {

	public SigaMeDTO toDO(Sigame sigame) {
		if (sigame == null) {
			return null;
		}

		return new SigaMeDTO(sigame.getId(), sigame.getName(), sigame.getType().getValue(),
				sigame.getCategory().getValue(), sigame.getStatus(), sigame.getRamal(), sigame.getDestiny());
	}

	public Sigame toEntity(SigaMeDTO sigaMeDTO) {
		if (sigaMeDTO == null) {
			return null;
		}

		Sigame sigame = new Sigame();

		if (sigaMeDTO.id() != null) {
			sigame.setId(sigaMeDTO.id());
		}

		sigame.setName(sigaMeDTO.name());
		sigame.setType(convertTypeValue(sigaMeDTO.type()));
		sigame.setCategory(convertCategoryValue(sigaMeDTO.category()));
		sigame.setStatus(sigaMeDTO.status());
		sigame.setRamal(sigaMeDTO.ramal());
		sigame.setDestiny(sigaMeDTO.destiny());
		return sigame;
	}

	public Type convertTypeValue(String value) {
		return Stream.of(Type.values()).filter(t -> t.getValue().equals(value)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	public Category convertCategoryValue(String value) {
		return switch (value) {
		case "Total" -> Category.TOTAL;
		case "Parcial" -> Category.PARCIAL;
		default -> throw new IllegalArgumentException("Categoria inválida: " + value);
		};
	}

}
