package com.green.miniProject.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardTag {

	private Long bno;
	private String mid; // fk 설정
	private String btitle;
	private String bcontent;
	private Long blike;
	private LocalDateTime bregdate;
	private LocalDateTime bmoddate;
	private String cmid; // fk 설정
	private String value; // Tag의 value(태그 당한 사람tagging)
}
