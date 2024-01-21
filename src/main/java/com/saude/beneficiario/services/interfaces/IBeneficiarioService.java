package com.saude.beneficiario.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.saude.beneficiario.entities.Beneficiario;

public interface IBeneficiarioService {

    List<Beneficiario> findAll();

	void insert(Beneficiario cliente);

	Optional<Beneficiario> findById(int id);

	void delete(int id);

	List<Beneficiario> findAllWithDocumentos();

	void save(Beneficiario paramBeneficiario);
}