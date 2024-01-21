package com.saude.beneficiario.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.saude.beneficiario.enums.MensagemEnum;
import com.saude.beneficiario.response.ResponseBase;
import com.saude.beneficiario.utils.MensagemUtils;

public class BaseController {

	@Autowired
	private MensagemUtils mensagemUtils;

	public ResponseBase responseSucesso(MensagemEnum mensagem, Object resposta) {
		ResponseBase response = new ResponseBase();
		response.setMsgSucesso(Arrays.asList(mensagemUtils.getTextoMensagem(mensagem.getKey())));
		if (resposta != null) {
			response.setResposta(resposta);
		}
		return response;
	}

	public ResponseBase responseSucesso(MensagemEnum mensagem) {
		return responseSucesso(mensagem, null);
	}
}
