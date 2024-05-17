package com.green.miniProject.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	
	@Id
	private String cno;
	private String cname;
	private String ctel;
	private String caddr1;
	private String caddr2;
	private String cemail;
	private LocalDate cfoundation;
	private Long camount;
	private String cintro;
	private String ctype;
	private String cdocnum;
}
