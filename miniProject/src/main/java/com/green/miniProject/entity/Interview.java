package com.green.miniProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "interview")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long ino;
	
	@OneToOne
	@JoinColumn(name = "arno")
	@ToString.Exclude
	@NotNull
	private ApplyResume arno;
	
	@Column(name = "ipass")
	@NotNull
	private int ipass;
	
}
