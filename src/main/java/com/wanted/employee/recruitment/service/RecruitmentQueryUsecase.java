package com.wanted.employee.recruitment.service;

import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentFindAllResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentFindDetailIdResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentFindListByOneResDto;

import java.util.List;


public interface RecruitmentQueryUsecase {
    RecruitmentFindDetailIdResDto findById(Long recruitmentId);

    RecruitmentFindAllResDto findAll();

    RecruitmentFindAllResDto findAllBySearchString(String search);
}
