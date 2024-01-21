package com.saude.beneficiario.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Beneficiario")
public class Beneficiario {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String telefone;
	
	@Column 
    private Date dataNascimento; 
	
	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
    private LocalDateTime dataInclusao; 
	
	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
    private LocalDateTime dataAtualizacao; 
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "beneficiario", cascade = CascadeType.ALL)
	private List<Documento> documentos;
	
}
