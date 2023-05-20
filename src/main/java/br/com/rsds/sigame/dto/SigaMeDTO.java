package br.com.rsds.sigame.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SigaMeDTO(
		Long id, 
		@NotBlank @NotNull @Length(min = 10, max = 11) String nome,
		@NotBlank @NotNull @Length(min = 5, max = 7) String tipo,
		@NotBlank @NotNull @Length(min = 6, max = 9) String categoria,
		@NotBlank @NotNull @Pattern(regexp = "Aberto|Concluido") @Length(min = 4, max = 4) String status,
		@NotBlank @NotNull @Length(min = 4, max = 12) String ramal, 
		@NotBlank @NotNull String destino

) {

}
