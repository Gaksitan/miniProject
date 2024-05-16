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
@Table(name="scrapEmployNotice")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScrapEmployNotice {
	@Id
	private Long senno;
	
	@ManyToMany
	@JoinColumn(name="enno")
	@ToString.Exclude
	private EmployNotice enno;
	
	@ManyToMany
	@JoinColumn(name="mid")
	@ToString.Exclude
	private Member mid;
}
