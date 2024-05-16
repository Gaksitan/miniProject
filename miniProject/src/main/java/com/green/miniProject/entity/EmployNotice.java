package com.green.miniProject.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employNotice")
public class EmployNotice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enno;
	
	@Column(nullable = false)
	private String enintro;
	
	@Column(nullable = false)
	private String entitle;
	
	@Column(nullable = false)
	private String enaddr;
	
	@Column(nullable = false)
	private Long ensalary;
	
	@Column(nullable = false)
	private String enposition;
	
	@Column(nullable = false)
	private LocalDate enenddate;
	
	@CreationTimestamp
	@UpdateTimestamp
	private LocalDate enregdate;
	
	@ManyToOne
	@JoinColumn(name="cno")
	@ToString.Exclude
	private Company cno;
}
