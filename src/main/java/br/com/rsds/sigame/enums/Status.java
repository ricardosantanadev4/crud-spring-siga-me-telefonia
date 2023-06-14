package br.com.rsds.sigame.enums;

public enum Status {
	ABERTO("Aberto"), CONCLUIDO("Concluido");

	private String value;

	Status(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
