package com.green.miniProject.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="serviceQuestion")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceQuestion {
	@Id
	private Long sqno;
	private String sqcontent;
	private String sqtitle;
	private boolean sqanswertf;
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime sqregdate;
	
	@ManyToOne
	@JoinColumn(name="mid")
	@ToString.Exclude
	private Member mid;
	
	
	@ManyToOne
	@JoinColumn(name="cno")
	@ToString.Exclude
	private Company cno;
}
