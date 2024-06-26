package com.green.miniProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyManager {
	
	private String cmid;
	private String cmpw;
	private String cmname;
	private String cmtel1;
	private String cmtel2;
	private String cmemail;
	private String cno;
	
	private String checkCmpw;
	
}
