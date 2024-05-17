package com.green.miniProject.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployNotice {
	private Long enno;
	private String enintro;
	private String entitle;
	private String enaddr;
	private Long ensalary;
	private String enposition;
	private LocalDate enenddate;
	private LocalDate enregdate;
	private String cno;
}
