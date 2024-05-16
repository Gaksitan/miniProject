package com.green.miniProject.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "blackAccount")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlackAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bano;
	
	@OneToMany
	@JoinColumn(name = "mid")
	@ToString.Exclude
	private Member mid;
	
	@OneToMany
	@JoinColumn(name = "cno")
	@ToString.Exclude
	private Company cno;
	
	@ManyToMany
	@JoinColumn(name = "ano")
	@ToString.Exclude
	private Admin ano;
	
	@CreationTimestamp
	@UpdateTimestamp
	@Column(name = "bregdate")
	private LocalDate bregdate;
}
