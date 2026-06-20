package com.app.model;

import com.app.constants.Specialization;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TeacherRequest {

    private String name;
    private String email;
    private Specialization specialization;
    private BigDecimal salary;

}
