package com.wanted.employee.recruitment.domain;

import com.wanted.employee.support.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
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
    @lombok.Builder.Default
    private Instant createdAt = Instant.now();
    @UpdateTimestamp
    private Instant updatedAt;

    public void changePosition(String position){
        this.position = position;
    }

    public void changeCompensation(Long compensation){
        this.compensation = compensation;
    }
    public void changeTechnology(String technology){
        this.technology = technology;
    }
    public void changeContents(String contents){
        this.contents = contents;
    }





}
