package com.green.miniProject.domain;


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
	private String rintro;
	private String rimgPath;
	private Boolean rpublic;
	private String rtitle;
	private Boolean rmain;
	private String mid;
	
	
	

}
