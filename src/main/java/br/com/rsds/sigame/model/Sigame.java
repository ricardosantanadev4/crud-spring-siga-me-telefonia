package br.com.rsds.sigame.model;

import org.hibernate.validator.constraints.Length;

import br.com.rsds.sigame.enums.Category;
import br.com.rsds.sigame.enums.Status;
import br.com.rsds.sigame.enums.Type;
import br.com.rsds.sigame.enums.converters.CategoryConverter;
import br.com.rsds.sigame.enums.converters.StatusConverter;
import br.com.rsds.sigame.enums.converters.TypeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Sigame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@NotNull
	@Column(name = "NAME", nullable = false, length = 100)
	@Length(min = 1, max = 100)
	private String name;

	@NotNull
	@Column(name = "TYPE", nullable = false, length = 11)
	@Convert(converter = TypeConverter.class)
	private Type type;

	@NotNull
	@Column(name = "CATEGORY", nullable = false, length = 7)
	@Convert(converter = CategoryConverter.class)
	private Category category;

	@NotNull
	@Column(name = "STATUS", nullable = false, length = 9)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.ABERTO;

	@NotBlank
	@NotNull
	@Column(name = "RAMAL", nullable = false, length = 4)
	@Length(min = 4, max = 4)
	private String ramal;

	@NotBlank
	@NotNull
	@Column(name = "DESTINY", nullable = false, length = 12)
	@Length(min = 4, max = 12)
	private String destiny;

}
