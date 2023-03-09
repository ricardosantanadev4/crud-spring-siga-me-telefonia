package br.com.rsds.sigame.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SIGAME")
@Data
public class Sigame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "TIPO")
	private String tipo;
	@Column(name = "CATEGORIA")
	private String categoria;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "RAMAL")
	private String ramal;
	@Column(name = "DESTINO")
	private String destino;
}
