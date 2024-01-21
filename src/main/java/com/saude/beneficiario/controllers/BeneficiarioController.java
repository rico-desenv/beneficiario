package com.saude.beneficiario.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.saude.beneficiario.entities.Beneficiario;
import com.saude.beneficiario.entities.Documento;
import com.saude.beneficiario.enums.MensagemEnum;
import com.saude.beneficiario.response.ResponseBase;
import com.saude.beneficiario.services.interfaces.IBeneficiarioService;

@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController extends BaseController {

	@Autowired
	private final IBeneficiarioService beneficiarioService;

	public BeneficiarioController(IBeneficiarioService beneficiarioService) {
		this.beneficiarioService = beneficiarioService;
	}

	@GetMapping("{id}")
	public Optional<Beneficiario> findById(@PathVariable("id") int id) {
		return beneficiarioService.findById(id);
	}

	@GetMapping("/listar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseBase getBeneficiarios() {
		return new ResponseBase(beneficiarioService.findAllWithDocumentos());
	}

	@PostMapping(value = "/incluir", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseBase postBeneficiario(@RequestBody Beneficiario beneficiario) {
		beneficiarioService.insert(beneficiario);
		return responseSucesso(MensagemEnum.MSG001);
	}
	
	@PostMapping(value = "/salvar", 
		consumes = { MediaType.APPLICATION_JSON_VALUE },
		produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseBase salvarBeneficiario(@RequestBody Beneficiario beneficiario) throws IOException {
		beneficiarioService.save(beneficiario);
		return responseSucesso(MensagemEnum.MSG001);
	}
	
	
	@DeleteMapping(value = "/excluir/{id}")
	public ResponseBase deleteBeneficiario(@PathVariable("id") int id) {
		beneficiarioService.delete(id);
		return responseSucesso(MensagemEnum.MSG006);		
	}
}
