package com.green.miniProject.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	@ManyToOne
	@JoinColumn(name = "mid")
	@ToString.Exclude
	private Member mid; // fk 설정
	private String btitle;
	private String bcontent;
	private Long blike;
	private LocalDate bregdate;
	private LocalDate bmoddate;
	private String btag;
	@ManyToOne
	@JoinColumn(name = "cno")
	@ToString.Exclude
	private Company cno; // fk 설정
}
