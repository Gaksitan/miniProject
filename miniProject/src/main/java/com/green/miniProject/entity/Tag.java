package com.green.miniProject.entity;

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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tno;
	@ManyToOne
	@JoinColumn(name = "tagger")
	@ToString.Exclude
	private Member taggerMid;
	@ManyToOne
	@JoinColumn(name = "tagging")
	@ToString.Exclude
	private Member taggingMid;
	@ManyToOne
	@JoinColumn(name = "bno")
	@ToString.Exclude
	private Board bno;
	
}