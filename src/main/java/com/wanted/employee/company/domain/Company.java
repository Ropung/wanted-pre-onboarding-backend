package com.wanted.employee.company.domain;


import com.wanted.employee.support.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class Company extends BaseEntity {
    private String name;
}
