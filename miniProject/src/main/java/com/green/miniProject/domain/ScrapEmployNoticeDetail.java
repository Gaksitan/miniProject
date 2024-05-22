package com.green.miniProject.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScrapEmployNoticeDetail {

	private Long senno;
	private Long enno;
	private String mid;
	private String cno;
	private String cname;
	private String enintro;
	private String entitle;
	private String enaddr;
	private Long ensalary;
	private String enposition;
	private LocalDate enenddate;
	private LocalDate enregdate;
}
