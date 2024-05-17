package com.green.miniProject.domain;

import java.time.LocalDate;

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
@Table(name = "employNotice")
public class EmployNotice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enno;
	
	private String enintro;
	private String entitle;
	private String enaddr;
	private Long ensalary;
	private String enposition;
	private LocalDate enenddate;
	private LocalDate enregdate;
	private String cno;
}
