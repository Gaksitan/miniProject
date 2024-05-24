package com.green.miniProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="subscribecompany")
public class SubscribeCompany {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sno;
	
	@ManyToOne
	@JoinColumn(name = "mid")
	@ToString.Exclude
	private Member mid;
	
	@ManyToOne
	@JoinColumn(name = "cno")
	@ToString.Exclude
	private Company cno;
}
