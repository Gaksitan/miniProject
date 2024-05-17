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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlackAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bano;
	private String mid;
	private String cno;
	private String ano;
	private LocalDate bregdate;
}
