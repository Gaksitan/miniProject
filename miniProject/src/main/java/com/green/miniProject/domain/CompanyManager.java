package com.green.miniProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "companyManager")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyManager {
	@Id
	private String cmid;
	private String cmpw;
	private String cmname;
	private String cmtel;
	private String cmemail;
	private String cno;
}
