package com.green.miniProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "companysector")
public class CompanySector {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scno;
	
	@ManyToOne
	@JoinColumn(name = "cno")
	@ToString.Exclude
	private Company cno;
	
	@Column(name = "scname")
	private String scname;
}
