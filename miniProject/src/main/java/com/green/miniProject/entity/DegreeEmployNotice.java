package com.green.miniProject.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
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
@Table(name = "degreeEmployNotice")
public class DegreeEmployNotice {
	@Id
	private Long deno;
	
	private String dename;
	private LocalDate degraddate;
	private String demajor;
	private String dehighestlevel;
	private EmployNotice enno;
}
