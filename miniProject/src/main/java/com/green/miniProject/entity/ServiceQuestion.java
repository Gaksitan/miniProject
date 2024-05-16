package com.green.miniProject.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceQuestion {
	@Id
	private Long sqno;
	private String sqcontent;
	private String sqtitle;
	private boolean sqanswertf;
	private LocalDateTime sqregdate;
	private Member mid;
	private Company cno;
}
