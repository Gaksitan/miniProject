package com.green.miniProject.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScoreComMem {

	private Long scmno;
	private int scmscore;
	private String scmreview;
	private LocalDateTime scmregdate;
	private String mid;
	private String cno;
}
