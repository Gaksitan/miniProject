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
public class Resume {
	

	private Long rno;
	private String mid;
	private String rintro;
	private String rimgPath;
	private Boolean rpublic;
	private String rtitle;
	private Boolean rmain;
	private LocalDate rregdate;
	
	
	
	

}
