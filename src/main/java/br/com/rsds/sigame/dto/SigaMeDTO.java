package br.com.rsds.sigame.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SigaMeDTO(Long id, @NotBlank @NotNull @Length(min = 1, max = 100) String name,
		@NotBlank @NotNull @Length(min = 5, max = 10) String type,
		@NotBlank @NotNull @Length(min = 6, max = 9) String category,
		@NotBlank @NotNull @Pattern(regexp = "Aberto|Concluido") @Length(min = 6, max = 9) String status,
		@NotBlank @NotNull @Length(min = 4, max = 4) String ramal, @NotBlank @NotNull String destiny

) {

}
