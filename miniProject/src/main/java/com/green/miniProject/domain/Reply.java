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
public class Reply {

	private Long reno;
	private String mid;
	private String recontent;
	private LocalDate reregdate;
	private LocalDate remoddate;
	private Long relike;
	private String cno;
	
}
