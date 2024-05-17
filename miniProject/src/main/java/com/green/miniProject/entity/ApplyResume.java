package com.green.miniProject.entity;

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

@Data
@Table(name = "applyResume")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ApplyResume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long arno; // 지원
	private Long rno;
	private Long enno;
	private int arpass;
}
