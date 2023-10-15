package com.wanted.employee.recruitment.service;

import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitCreateReqDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitCreateResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitDeleteResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitUpdateReqDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitUpdateResDto;
import org.springframework.stereotype.Service;


public interface RecruitmentCommandUsecase {
    RecruitCreateResDto create( RecruitCreateReqDto dto);
    RecruitUpdateResDto update(Long recruitmentId, RecruitUpdateReqDto dto);
    RecruitDeleteResDto delete(Long recruitmentId);
}
