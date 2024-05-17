package com.green.miniProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TempResume {

	
	private Long trno;
	private String mid;
	private String trintro;
	private String trimgPath;
	private Boolean trpublic;
	private String trtitle;
	private Boolean trmain;
	
}
