package com.saude.beneficiario.exceptions;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = -3365871767922400929L;

	public NegocioException(String key, Object... args) {
		super(key);
		this.codigo = key;
		this.mensagem = key;
		this.args = args;
		this.printLog = true;
	}

	public NegocioException(String key, Boolean printLog, String... args) {
		super(key);
		this.codigo = key;
		this.mensagem = key;
		this.args = args;
		this.printLog = printLog;
	}

	public NegocioException(String key, Throwable cause) {
		super(key, cause);
		this.printLog = true;
	}

	private Object[] args;
	private String codigo;
	private String mensagem;
	private boolean printLog;

	public Object[] getArgs() {
		return args;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public boolean isPrintLog() {
		return printLog;
	}
}
