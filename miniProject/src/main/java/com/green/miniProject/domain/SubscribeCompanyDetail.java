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
public class SubscribeCompanyDetail {

	private Long sno;
	private String mid;
	private String cno;
	private String cname;
	private String ctel;
	private String caddr1;
	private String caddr2;
	private String cemail;
	private LocalDate cfoundation;
	private Long camount;
	private String cintro;
	private String ctype;
	private String cdocnum;
}
