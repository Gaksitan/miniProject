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
public class Experience {

	private Long exno;
	private Long rno;
	private String exname;
	private LocalDate exjoindate;
	private LocalDate exleavedate;
	private String exposition;
	private String exrank;
}
