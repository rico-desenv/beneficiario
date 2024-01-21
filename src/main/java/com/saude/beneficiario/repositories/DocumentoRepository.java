package com.saude.beneficiario.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saude.beneficiario.entities.Documento;

@Repository
public interface DocumentoRepository extends CrudRepository<Documento, Long> {

	Optional<Documento> findById(int id);
	
	void deleteByBeneficiarioId(int beneficiarioId);
}