package com.green.miniProject.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skno;
	private Long rno;
	private String skname;

}
