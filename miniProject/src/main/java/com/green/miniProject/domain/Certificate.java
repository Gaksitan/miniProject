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
public class Certificate {
	
	private Long ceno;
	private Long rno;
	private String cename;
	private LocalDate cedate;
	private String celocation;
	
}
