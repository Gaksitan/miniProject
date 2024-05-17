package com.green.miniProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skillEmployNotice")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillEmployNotice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skno;

	private Long enno;
	

	
	

	private String skname;
	
}
