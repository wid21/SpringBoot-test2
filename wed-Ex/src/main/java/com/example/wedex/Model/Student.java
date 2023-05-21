package com.example.wedex.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    @NotNull(message = "id should be not null")
    private int ID ;
    @NotEmpty(message = "name should be not null")
    private String  name;
    @NotNull(message = "age should be not null")
    private int  age;
    @NotEmpty(message = "major should be not null")
    private String major;
}
