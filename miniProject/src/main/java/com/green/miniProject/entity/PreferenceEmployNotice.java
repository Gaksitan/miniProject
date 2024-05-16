package com.green.miniProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "preferenceEmployNotice")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreferenceEmployNotice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pno;
	
	@OneToMany
	@JoinColumn(name = "enno")
	@ToString.Exclude
	private EmployNotice enno;
	
	@Column(name = "pname")
	private String pname;
}
