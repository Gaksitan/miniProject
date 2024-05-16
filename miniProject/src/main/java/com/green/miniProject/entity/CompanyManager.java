package com.green.miniProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "companyManager")
public class CompanyManager {
	@Id
	private String cmid;
	
	@Column(nullable = false)
	private String cmpw;
	
	@Column(nullable = false)
	private String cmname;
	
	@Column(length = 13, nullable = false)
	private String cmtel;
	
	@Column(nullable = false)
	private String cmemail;
	
	@ManyToOne
	@JoinColumn(name="cno")
	@ToString.Exclude
	private Company cno;
}
