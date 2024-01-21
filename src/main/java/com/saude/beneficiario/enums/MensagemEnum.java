package com.saude.beneficiario.enums;

public enum MensagemEnum {

	MSG001("MSG001"), MSG002("MSG002"), MSG003("MSG003"), MSG004("MSG004"), MSG005("MSG005"), MSG006("MSG006"), MSG007("MSG007");

	public String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private MensagemEnum(String key) {
		this.key = key;
	}
}
