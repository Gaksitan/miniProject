package com.green.miniProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "followCompany")
public class FollowCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fno;
	
	@Column(nullable = false)
	private String following;
	
	@ManyToMany
	@JoinColumn(name="follower")
	@ToString.Exclude
	private CompanyManager cmid;
}
