package com.wanted.employee.recruitment.api.dto;

import lombok.Builder;

import java.time.Instant;
import java.util.List;

public record RecruitmentQueryDto() {

    @Builder
    public record RecruitmentFindDetailIdResDto(
            Long id,
            String companyName,
            String country,
            String region,
            String position,
            Long compensation,
            String technology,
            String contents,
            List<RecruitmentIdProjectionDto> otherRecruitmentIdList,
            Instant createdAt,
            Instant updatedAt
    ) {}

    public record RecruitmentIdProjectionDto(
            Long id
    ) {}

    @Builder
    public record RecruitmentFindListByOneResDto(
            Long id,
            String companyName,
            String country,
            String region,
            String position,
            Long compensation,
            String technology
    ) {}


    @Builder
    public record RecruitmentFindAllResDto(
            List<RecruitmentFindListByOneResDto> RecruitmentList
    ){
    }
}
