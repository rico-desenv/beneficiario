package com.saude.beneficiario.response;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class ResponseBase implements Serializable {

	private static final long serialVersionUID = -2772590867216223158L;

	private Object resposta;
	private List<String> msgSucesso = new ArrayList<>();
	private List<String> msgErro = new ArrayList<>();
	private List<String> msgAlerta = new ArrayList<>();
	
	public ResponseBase(Object resposta) {
		this.resposta = resposta;
	}

}
