package com.green.miniProject.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private String mid;
	
	private String mpw;
	
	private String memail;
	
	private String mtel1;
	
	private String mtel2;
	
	private LocalDate mbirthDate;
	
	private String mname;
	
	private String maddr1;

	private String maddr2;
	
	private LocalDate mregDate;
	
	private int mstate;
	
	private char mgender;
	
	public Member(String mid, String mpw, String mname, String maddr1, String maddr2, String mtel1, String mtel2, int mstate, char mgender) {
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.maddr1 = maddr1;
		this.maddr2 = maddr2;
		this.mtel1 = mtel1;
		this.mtel2 = mtel2;
		this.mstate = mstate;
		this.mgender = mgender;
	}
	
	
	
}
