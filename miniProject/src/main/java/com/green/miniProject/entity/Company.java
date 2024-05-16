package com.green.miniProject.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cno;
	
	@Column(nullable = false)
	private String cname;
	
	@Column(length = 13)
	private String ctel;
	
	@Column(nullable = false)
	private String caddr1;
	
	private String caddr2;
	
	private String cemail;
	
	private LocalDate cfoundation;
	
	private Long camount;
	
	private String cintro;
	
	@Column(nullable = false)
	private String ctype;
	
	@Column(nullable = false)
	private String cdocnum;
}
