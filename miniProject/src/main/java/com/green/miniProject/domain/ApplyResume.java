package com.green.miniProject.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ApplyResume {
	
	private Long arno; // 지원
	private Long rno;
	private Long enno;
	private int arpass;
}
