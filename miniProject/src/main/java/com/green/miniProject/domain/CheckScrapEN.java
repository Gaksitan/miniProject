package com.green.miniProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckScrapEN {
	private Long senno;
	private Long enno;
	private String mid;
	private String entitle;
	private String enintro;
	private String enposition;
	private String cname;
}
