package br.com.rsds.sigame.enums;

public enum Type {
	PROVISORIO("Provisorio"),PERMANENTE("Permanente");
	
	private String value;
	
	Type(String value) {
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
