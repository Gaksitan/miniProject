package com.green.miniProject.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ScoreMemCom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ToString.Exclude
	private Long smcno;
	@ManyToMany
	@JoinColumn(name = "mid")
	@ToString.Exclude
	private Member mid;
	@ManyToMany
	@JoinColumn(name = "cno")
	@ToString.Exclude
	private Company cno;
	private int smcscore;
	private String smcreview;
	private LocalDate smcregdate;
}
