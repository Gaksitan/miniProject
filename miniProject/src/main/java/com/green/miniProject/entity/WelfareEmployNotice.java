package com.green.miniProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "welfareEmployNotice")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WelfareEmployNotice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long wno;
	
	@OneToMany
	@NotNull
	@JoinColumn(name = "enno")
	@ToString.Exclude
	private EmployNotice enno;

	@Column(name = "wname")
	@NotNull
	private String wname;
	
}
