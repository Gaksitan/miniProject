package com.green.miniProject.domain;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCategory {

	private Long qcno;
	private String qcname;
	private String sqno;
}
