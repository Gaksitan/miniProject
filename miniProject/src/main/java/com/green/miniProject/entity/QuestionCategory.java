package com.green.miniProject.entity;


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
public class QuestionCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qcno;
	private String qcname;
	private ServiceQuestion sqno;
}
