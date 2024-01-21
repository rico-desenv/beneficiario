package com.saude.beneficiario.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.saude.beneficiario.entities.Beneficiario;
import com.saude.beneficiario.enums.MensagemEnum;
import com.saude.beneficiario.exceptions.NegocioException;
import com.saude.beneficiario.repositories.BeneficiarioRepository;
import com.saude.beneficiario.repositories.DocumentoRepository;
import com.saude.beneficiario.services.interfaces.IBeneficiarioService;

import lombok.SneakyThrows;

@Service
public class BeneficiarioService implements IBeneficiarioService {

	private final BeneficiarioRepository repository;
    
    private final DocumentoRepository documentoRepository;

    public BeneficiarioService(BeneficiarioRepository repository, DocumentoRepository documentoRepository) {
		this.repository = repository;
		this.documentoRepository = documentoRepository;
    }
    
    @Override
    public Optional<Beneficiario> findById(int id) {
        return repository.findById(id);
    }
    
    @Override
    public List<Beneficiario> findAll() {
        return (List<Beneficiario>) repository.findAll();
    }
    
    @Override
    public List<Beneficiario> findAllWithDocumentos() {
    	return (List<Beneficiario>) repository.findAll();
    }
    
    @Override
    @SneakyThrows
    @Transactional
	public void insert(Beneficiario beneficiario) {
		validate(beneficiario);
    	repository.save(beneficiario);    	
    }
    
    @Override
    @SneakyThrows
    @Transactional
	public void delete(int id) {
    	Optional<Beneficiario> beneficiario = repository.findById(id);
		if (beneficiario == null)
			throw new NegocioException(MensagemEnum.MSG002.getKey(), "Beneficiarios");
		
		repository.delete(beneficiario.get());
    }
    
    @Override
    @SneakyThrows
    @Transactional
	public void save(Beneficiario param) {
    	if (param.getId()>0) {
        	Optional<Beneficiario> beneficiario = repository.findById(param.getId());
    		if (beneficiario == null)
    			throw new NegocioException(MensagemEnum.MSG002.getKey(), "Beneficiarios");	
    		
    		if (param.getDocumentos().size()>0) {
    			documentoRepository.deleteByBeneficiarioId(param.getId());
    		}
    	}
    	
    	validate(param);
		repository.save(param);		    	
    }      
    
    private void validate(Beneficiario beneficiario) {
		if (beneficiario == null)
			throw new NegocioException(MensagemEnum.MSG002.getKey(), "Beneficiarios");
		if (beneficiario.getNome() == null)
			throw new NegocioException(MensagemEnum.MSG003.getKey(), "Beneficiarios");
		if (beneficiario.getTelefone() == null)
			throw new NegocioException(MensagemEnum.MSG004.getKey(), "Beneficiarios");	
    }

}