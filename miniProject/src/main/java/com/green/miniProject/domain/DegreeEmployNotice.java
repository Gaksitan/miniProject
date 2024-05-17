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
public class DegreeEmployNotice {
	private Long deno;
	private String dename;
	private LocalDate degraddate;
	private String demajor;
	private String dehighestlevel;
	private Long enno;
}
