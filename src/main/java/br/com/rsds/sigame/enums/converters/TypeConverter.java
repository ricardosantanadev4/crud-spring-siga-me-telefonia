package br.com.rsds.sigame.enums.converters;

import java.util.stream.Stream;

import br.com.rsds.sigame.enums.Type;
import jakarta.persistence.AttributeConverter;

public class TypeConverter implements AttributeConverter<Type, String> {

	@Override
	public String convertToDatabaseColumn(Type attribute) {
		return attribute.getValue();
	}

	@Override
	public Type convertToEntityAttribute(String dbData) {
		return Stream.of(Type.values()).filter(t -> t.getValue().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
