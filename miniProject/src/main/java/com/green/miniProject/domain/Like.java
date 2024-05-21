package com.green.miniProject.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Like {

	private Long lino;
	private String mid;
	private String cmid;
	private Long bno;
	private Long reno;
	
}
