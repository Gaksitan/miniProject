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
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cno;
	
	@Column(name = "cname")
	private String cname;
	
	@Column(name = " ctel")
	private String ctel;
	
	@Column(name = "caddr1")
	private String caddr1;
	
	@Column(name = "caddr2")
	private String caddr2;
	
	@Column(name = "cemail")
	private String cemail;
	
	@Column(name = "cfoundation")
	private LocalDate cfoundation;
	
	@Column(name = "camount")
	private Long camount;
	
	@Column(name = "cintro")
	private String cintro;
	
	@Column(name = "ctype")
	private String ctype;
	
	@Column(name = "cdocnum")
	private String cdocnum;
}
