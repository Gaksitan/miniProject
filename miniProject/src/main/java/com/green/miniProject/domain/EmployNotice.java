package com.green.miniProject.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployNotice {
    private Long enno;
    private String enintro;
    private String entitle;
    private String enaddr;
    private Long ensalary;
    private String enposition;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enenddate;
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enregdate;
    private String cno;
    
    private Long applicant_count;
    
}