package com.green.miniProject.domain;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceQuestion {
	private Long sqno;
	private String sqcontent;
	private String sqtitle;
	private boolean sqanswertf;
	private LocalDateTime sqregdate;
	private String mid;
	private String cno;
	private Long qcno;
	private String qcname;
	
	
	public ServiceQuestion(Long sqno, String sqcontent, String sqtitle, boolean sqanswertf, LocalDateTime sqregdate,
			String mid, String cno, Long qcno) {
		this.sqno = sqno;
		this.sqcontent = sqcontent;
		this.sqtitle = sqtitle;
		this.sqanswertf = sqanswertf;
		this.sqregdate = sqregdate;
		this.mid = mid;
		this.cno = cno;
		this.qcno = qcno;
	}
	
	
}
