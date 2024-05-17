package com.green.miniProject.domain;

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
public class CompanySector {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scno;
	private String cno;
	private String scname;
}
