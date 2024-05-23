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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "member")
@Data
public class Member {
	
	@Id
	private String mid;

	@Column(name = "mpw")
	private String mpw;
	
	@Column(name = "memail")
	private String memail;
	
	@Column(name = "mtel")
	private String mtel;
	
	@Column(name = "mbirthDate")
	private LocalDate mbirthDate;
	
	@Column(name = "mname")
	private String mname;
	
	@Column(name = "maddr1")
	private String maddr1;
	
	@Column(name = "maddr2")
	private String maddr2;
	
	@Column(name = "mregdate")
	private LocalDate mregdate;
	
	@Column(name = "mstate")
	private int mstate;
	
	@Column(name = "mgender")
	private String mgender;
}
