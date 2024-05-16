package com.green.miniProject.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="member")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	private String mid;
	
	@Column(nullable=false)
	private String mpw;
	
	@Column(nullable=false, unique=true)
	private String memail;
	
	@Column(nullable=false, unique=true)
	private String mtel;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date mbirthDate;
	
	private String mname;
	
	@Column(nullable=false)
	private String maddr1;
	
	@Column(nullable=false)
	private String maddr2;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date mregDate;
	
	private int msate;
	
	private char mgender;
}
