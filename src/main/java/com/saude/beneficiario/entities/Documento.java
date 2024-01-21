package com.saude.beneficiario.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Documento")
public class Documento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int tipoDocumento;
	
	@Column
	private String descricao;
	
	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
    private LocalDateTime dataInclusao; 
	
	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
    private LocalDateTime dataAtualizacao; 
	
	@JsonBackReference
	@JoinColumn(name = "BENEFICIARIO_ID")
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Beneficiario beneficiario;
	
}
