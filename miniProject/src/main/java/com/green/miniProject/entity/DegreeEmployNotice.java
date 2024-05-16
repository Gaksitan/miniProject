package com.green.miniProject.entity;

import java.time.LocalDate;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "degreeEmployNotice")
public class DegreeEmployNotice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deno;
	
	private String dename;
	private LocalDate degraddate;
	private String demajor;
	private String dehighestlevel;
	
	@ManyToOne
	@JoinColumn(name="enno")
	@ToString.Exclude
	private EmployNotice enno;
}
