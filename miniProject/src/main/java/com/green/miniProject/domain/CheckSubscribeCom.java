package com.green.miniProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckSubscribeCom {
	private Long sno;
	private String mid;
	private String cno;
	private String cname;
	private String cintro;
	private String csname;
}
