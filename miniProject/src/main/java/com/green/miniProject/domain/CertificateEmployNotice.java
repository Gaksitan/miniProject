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
public class CertificateEmployNotice {
	
	private Long ceno;
	private Long enno;
	private String cename;
	private LocalDate cedate;
	private String celocation;

}
