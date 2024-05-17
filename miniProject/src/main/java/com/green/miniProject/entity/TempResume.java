package com.green.miniProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TempResume {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trno;
	
	@OneToMany
	@JoinColumn(name = "mid")
	private String mid;
	private String trintro;
	private String trimgPath;
	private Boolean trpublic;
	private String trtitle;
	private Boolean trmain;
	
}
