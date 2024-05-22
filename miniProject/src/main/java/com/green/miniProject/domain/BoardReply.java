package com.green.miniProject.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BoardReply {
	
	private Long reno;
	private String mid;
	private String recontent;
	private LocalDate reregdate;
	private LocalDate remoddate;
	private Long relike;
	private String cmid;
	private Long bno;
	private String btitle;
}
