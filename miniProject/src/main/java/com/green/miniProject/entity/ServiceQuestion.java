package com.green.miniProject.entity;

import java.time.LocalDateTime;


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
public class ServiceQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqno;
	private String sqcontent;
	private String sqtitle;
	private boolean sqanswertf;
	private LocalDateTime sqregdate;
	private String mid;
	private String cno;
	private Long qcno;
}
