package br.com.rsds.sigame.enums;

public enum Category {
	TOTAL("Total"), PARCIAL("Parcial");

	private String value;

	Category(String value) {
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
