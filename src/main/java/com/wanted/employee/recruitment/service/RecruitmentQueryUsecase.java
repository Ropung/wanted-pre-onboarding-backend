package com.wanted.employee.recruitment.service;

import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentFindAllResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentFindDetailIdResDto;


public interface RecruitmentQueryUsecase {
    RecruitmentFindDetailIdResDto findById(Long recruitmentId);

    RecruitmentFindAllResDto findAll();
}
