package br.com.rsds.sigame.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Sigame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@NotNull
	@Column(name = "NOME", nullable = false, length = 100)
	@Length(min = 1, max = 100)
	private String nome;

	@NotBlank
	@NotNull
	@Column(name = "TIPO", nullable = false, length = 11)
	@Length(min = 10, max = 11)
	private String tipo;

	@NotBlank
	@NotNull
	@Column(name = "CATEGORIA", nullable = false, length = 7)
	@Length(min = 5, max = 7)
	private String categoria;

	@NotBlank
	@NotNull
	@Column(name = "STATUS", nullable = false, length = 9)
	@Length(min = 6, max = 9)
	@Pattern(regexp = "Aberto|Concluido")
	private String status = StatusSigaMe.Aberto.toString();

	@NotBlank
	@NotNull
	@Column(name = "RAMAL", nullable = false, length = 4)
	@Length(min = 4, max = 4)
	private String ramal;

	@NotBlank
	@NotNull
	@Column(name = "DESTINO", nullable = false, length = 12)
	@Length(min = 4, max = 12)
	private String destino;

}
