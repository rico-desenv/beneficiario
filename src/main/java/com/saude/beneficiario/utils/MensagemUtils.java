package com.saude.beneficiario.utils;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MensagemUtils {

	@Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;

	public String getMensagem(final String key, final Object... args) {
		final String MSG_NAO_ENCONTRADA = "{0}-> Mensagem não encontrada";
		try {
			return resourceBundleMessageSource.getMessage(key, args, Locale.GERMAN);
		} catch (Exception e) {
			System.out.println(MessageFormat.format(MSG_NAO_ENCONTRADA, key));
		}
		return key;
	}

	public String getTextoMensagem(String key, Object... args) {
		return resourceBundleMessageSource.getMessage(key, args, Locale.GERMAN);
	}
}
