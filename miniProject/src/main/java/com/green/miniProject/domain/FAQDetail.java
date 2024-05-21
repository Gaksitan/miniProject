package com.green.miniProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FAQDetail {
	
	private Long faqno;
	private String faqquestion;
	private String faqanswer;
	private Long qcno;
	private String faqtitle;
	private String faqtarget;
	private String qcname;
	
}
