package com.wanted.employee.recruitment.api.dto;

import lombok.Builder;

public record RecruitmentCommandDto() {

    public record RecruitCreateReqDto(
            Long companyId,
            String companyName,
            String country,
            String region,
            String position,
            Long compensation,
            String technology,
            String contents
    ){}

    @Builder
    public record RecruitCreateResDto(
            Long companyId,
            String companyName,
            String country,
            String region,
            String position,
            Long compensation,
            String technology,
            String contents
    ){}

    public record RecruitUpdateReqDto(
            String position,
            Long compensation,
            String technology,
            String contents
    ){}
    @Builder
    public record RecruitUpdateResDto(
            String position,
            Long compensation,
            String technology,
            String contents
    ){}

    @Builder
    public record RecruitDeleteResDto(
            boolean success
    ){}


}
