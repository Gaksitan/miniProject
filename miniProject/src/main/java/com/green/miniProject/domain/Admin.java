package com.green.miniProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {

	private String ano; // 사원번호
	private String aid; // 관리자 아이디
	private String apw; // 관리자 비밀번호

	
}
