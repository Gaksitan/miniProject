package com.green.miniProject.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ceno;
	private Long rno;
	private String cename;
	private LocalDate cedate;
	private String celocation;
	
}
