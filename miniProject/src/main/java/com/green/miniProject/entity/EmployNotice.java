package com.green.miniProject.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "employnotice")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployNotice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enno;
	
	@JoinColumn(name = "cno")
	@ManyToOne
	@ToString.Exclude
	private Company cno;
	
	@Column(name = "enintro")
	private String enintro;
	
	@Column(name = "entitle")
	private String entitle;
	
	@Column(name = "enaddr")
	private String enaddr;
	
	@Column(name = "ensalary")
	private Long ensalary;
	
	@Column(name = "enposition")
	private String enposition;
	
	@Column(name = "enenddate")
	private LocalDate enenddate;
	
	@Column(name = "enregdate")
	private LocalDate enregdate;
}

