package com.example.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeStats {
    private Long count;
    private Double sumBonus;
    private Double sumSalary;
    private Double meanSalary;
}
