package com.green.miniProject.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
@Table(name = "scoreComMem")
public class ScoreComMem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scmno;
	
	@Column(nullable = false)
	private int scmscore;
	
	private String scmreview;
	
	@CreatedDate
	private LocalDateTime scmregdate;
	
	@ManyToMany
	@JoinColumn(name="mid")
	@ToString.Exclude
	private Member mid;
	
	@ManyToMany
	@JoinColumn(name="cno")
	@ToString.Exclude
	private Company cno;
}
