package com.wanted.employee.recruitment.domain;

import com.wanted.employee.support.BaseEntity;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

public class Recruitment extends BaseEntity {
    private Long companyId;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private Long compensation;
    private String technology;
    private String contents;
    @CreatedDate
    private Instant createdAt = Instant.now();
    @UpdateTimestamp
    private Instant updatedAt;
}
