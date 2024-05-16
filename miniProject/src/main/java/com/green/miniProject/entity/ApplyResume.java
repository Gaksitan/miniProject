package com.green.miniProject.entity;

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
public class ApplyResume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long arno;
	@ManyToMany
	@JoinColumn(name = "rno")
	@ToString.Exclude
	private Resume rno;
	@ManyToMany
	@JoinColumn(name = "enno")
	@ToString.Exclude
	private EmployNotice enno;
	private int arpass;
}