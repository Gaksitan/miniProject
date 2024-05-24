package com.green.miniProject.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoinApplyResumeList {
	private String cname;
	private Long enno;
	private String entitle;
	private LocalDate applydate;
	private int arpass;
	private int ipass;
	private Long rno;
	private String mid;
	
	public JoinApplyResumeList(String cname, Long enno, String entitle, LocalDate applydate, int arpass, int ipass,
			Long rno, String mid) {
		this.cname = cname;
		this.enno = enno;
		this.entitle = entitle;
		this.applydate = applydate;
		this.arpass = arpass;
		this.ipass = ipass;
		this.rno = rno;
		this.mid = mid;
	}

	private boolean scrap;
	
	
}
