package com.green.miniProject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="questionCategory")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCategory {
	@Id
	private Long qcno;
	private String qcname;
	
	@OneToOne
	@JoinColumn(name="sqno")
	@ToString.Exclude
	private ServiceQuestion sqno;
}
