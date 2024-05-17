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
public class Degree {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deno;
	private Resume rno;
	private String dename;
    private LocalDate degraddate;
    private String demajor;
    private String dehighestlevel;
	
}
