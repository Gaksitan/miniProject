package com.green.miniProject.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Board {
	private Long bno;
	private String mid; // fk 설정
	private String btitle;
	private String bcontent;
	private Long blike;
	private LocalDateTime bregdate;
	private LocalDateTime bmoddate;
	private String cno; // fk 설정
}
