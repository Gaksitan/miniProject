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
@Table(name="interestMember")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterestMember {
	@Id
	private Long imno;
	
	@ManyToMany
	@JoinColumn(name="cno")
	@ToString.Exclude
	private Company cno;
	
	
	@ManyToMany
	@JoinColumn(name="mid")
	@ToString.Exclude
	private Member mid;
	
}
