package com.green.miniProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FAQ {
	private Long faqno;
	private String faqquestion;
	private String faqanswer;
	private Long qcno;
	private String faqtitle;
	private String faqtarget;
	
	
	public FAQ(String faqquestion, String faqanswer, Long qcno, String faqtitle, String faqtarget) {
		this.faqquestion = faqquestion;
		this.faqanswer = faqanswer;
		this.qcno = qcno;
		this.faqtitle = faqtitle;
		this.faqtarget = faqtarget;
	}
	
	
	

}
