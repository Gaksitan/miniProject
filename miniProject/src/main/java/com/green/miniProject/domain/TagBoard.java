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
public class TagBoard {
	private Long bno;
	private String btitle;
	private LocalDateTime bregdate;
	private String mid;
	private Long blike;
	private String cmid;
	private String value;
}
