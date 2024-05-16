package com.green.miniProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="subscribeCompany")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeCompany {
	@Id
	private Long sno;
	
	@ManyToMany
	@JoinColumn(name="mid")
	@ToString.Exclude
	private Member mid;
	
	
	@ManyToMany
	@JoinColumn(name="cno")
	@ToString.Exclude
	private Company cno;
	
}
