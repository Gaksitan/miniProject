package com.green.miniProject.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.green.miniProject.domain.CompanyManager;
import com.green.miniProject.domain.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	
	@JoinColumn(name = "mid")
	//@ManyToOne
	@ToString.Exclude
	private String mid;
	
	@JoinColumn(name = "cmid")
	//@ManyToOne
	@ToString.Exclude
	private String cmid;
	
	@Column(name = "btitle")
	@NotNull
	private String btitle;
	
	@Column(name = "bcontent")
	@NotNull
	private String bcontent;
	
	@Column(name = "blike")
	private Long blike;
	
	@Column(name = "bregdate")
	private LocalDateTime bregdate;
	
	@Column(name = "bmoddate")
	private LocalDateTime bmoddate;
	
	
	
	
	
}
