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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "notice")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nno;
	
	@OneToMany
	@JoinColumn(name = "ano")
	@ToString.Exclude
	private Admin ano;
	
	@Column(name = "ntitle")
	private String ntitle;
	
	@Column(name = "ncontnet")
	private String ncontent;
	
	@CreationTimestamp
	@UpdateTimestamp
	@Column(name = "nregdate")
	private LocalDate nregdate;
	
}
