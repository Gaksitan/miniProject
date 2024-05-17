package com.green.miniProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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
	private Company cno;
}
