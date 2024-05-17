package com.green.miniProject.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "certificateEmployNotice")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificateEmployNotice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ceno;
	private Long enno;
	private String cename;
	private LocalDate cedate;
	private String celocation;

}
