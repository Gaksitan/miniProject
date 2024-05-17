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
public class ScoreMemCom {

	private Long smcno;
	private String mid;
	private String cno;
	private int smcscore;
	private String smcreview;
	private LocalDate smcregdate;
}
