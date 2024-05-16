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
@Table(name="followMember")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FollowMember {
	@Id
	private Long fmno;
	
	private Member following;
	
	@ManyToMany
	@JoinColumn(name="follower")
	@ToString.Exclude
	private Member mid;
}
