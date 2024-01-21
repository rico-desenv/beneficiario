package com.saude.beneficiario.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saude.beneficiario.entities.Beneficiario;

@Repository
public interface BeneficiarioRepository extends CrudRepository<Beneficiario, Long> {

	Optional<Beneficiario> findById(int id);
	
}