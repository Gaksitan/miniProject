package com.green.miniProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class tagCom {
	private Long tno;
	private String tagger;
	private String value;
	private Long bno;

}
