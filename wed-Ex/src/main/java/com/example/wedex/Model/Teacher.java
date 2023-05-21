package com.example.wedex.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {
    @NotNull(message = "id should be not null")
    private int ID ;
    @NotEmpty(message = "name should be not null")
    private String  name;
    @NotNull(message = "salary should be not null")
    private double  salary;

}
