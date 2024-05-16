package com.green.miniProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class TempResume {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trno;
	
	@ManyToOne
	@JoinColumn(name = "mid")
	@ToString.Exclude
	private Member mid;
	private String trintro;
	private String trimgPath;
	private Boolean trpublic;
	private String trtitle;
	private Boolean trmain;
	
}
