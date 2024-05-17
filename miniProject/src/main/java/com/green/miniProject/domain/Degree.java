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
@Table(name = "degree")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Degree {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deno;
	private Long rno;
	private String dename;
    private LocalDate degraddate;
    private String demajor;
    private String dehighestlevel;
	
}