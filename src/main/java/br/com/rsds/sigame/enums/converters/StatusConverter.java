package br.com.rsds.sigame.enums.converters;

import java.util.stream.Stream;

import br.com.rsds.sigame.enums.Status;
import jakarta.persistence.AttributeConverter;

public class StatusConverter implements AttributeConverter<Status, String> {

	@Override
	public String convertToDatabaseColumn(Status attribute) {
		return attribute.getValue();
	}

	@Override
	public Status convertToEntityAttribute(String dbData) {
		return Stream.of(Status.values()).filter(s -> s.getValue().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}