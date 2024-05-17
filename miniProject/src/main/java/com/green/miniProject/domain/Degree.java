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
public class Degree {

	private Long deno;
	private Long rno;
	private String dename;
    private LocalDate degraddate;
    private String demajor;
    private String dehighestlevel;
	
}
