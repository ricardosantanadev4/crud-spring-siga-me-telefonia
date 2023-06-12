package br.com.rsds.sigame.enums.converters;

import java.util.stream.Stream;

import br.com.rsds.sigame.enums.Category;
import jakarta.persistence.AttributeConverter;

public class CategoryConverter implements AttributeConverter<Category, String> {

	@Override
	public String convertToDatabaseColumn(Category attribute) {
		return attribute.getValue();
	}

	@Override
	public Category convertToEntityAttribute(String dbData) {
		return Stream.of(Category.values()).filter(c -> c.getValue().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
